import java.util.Scanner;
class chainUtils{
    public Node<Integer> turnToChain(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = scanner.nextInt();
        if(number < 0){
            return null;
        }
        Node<Integer> head = new Node<Integer>(number);
        Node<Integer> current = head;
        System.out.println("Enter next number:");
        number = scanner.nextInt();
        while(number >= 0){
            Node<Integer> newNode = new Node<Integer>(number);
            current.setNext(newNode);
            current = newNode;
            System.out.println("Enter next number:");
            number = scanner.nextInt();
        }
        return head;
    }
    public Node<Integer> insert(Node<Integer> head, int num) {
    Node<Integer> node = head;
    Node<Integer> newNode = new Node<Integer>(num);
    
    if(node == null) {
        return newNode;
    }
    
    if(num < head.getValue()) {
        newNode.setNext(head);
        return newNode;
    }
    
    while(node.getNext() != null && node.getNext().getValue() < num) {
        node = node.getNext();
    }
    
    newNode.setNext(node.getNext());
    node.setNext(newNode);
    return head;
}
    public Node<Integer> specialInsert1(Node<Integer> head){
        if(head == null){
            return null;
        }
        Node<Integer> node = head;
 
    while(node.getNext() != null){
        if(node.getValue() % 2 == 0){
            Node<Integer> tempNode = new Node<Integer>(-1);
            tempNode.setNext(node.getNext());
            node.setNext(tempNode);
        }
        node = node.getNext();
    }
    if(head.getValue() % 2 == 0){
        Node<Integer> tempNode = new Node<Integer>(-1);
        tempNode.setNext(head);
        head = tempNode;
    }
    return head;
    }
    public void specialInsert2(Node<Integer> head, int num){
        while(head != null){
            if(head.getValue() < num){
                Node<Integer> newNode = new Node<Integer>(num);
                newNode.setNext(head.getNext());
                head.setNext(newNode);
                head = head.getNext();
            }
            head = head.getNext();
    }
}
    public String turnToString(Node<Character> head){
        String str = "";
        boolean firstSpaceInSequence = true;
        while(head != null){
            if(head.getValue() == ' '){
                if(firstSpaceInSequence == true){
                    str += ' ';
                    firstSpaceInSequence = false;
                }
            } 
            else{
                str += head.getValue();
                firstSpaceInSequence = true;
            }
            head = head.getNext();
        }
        return str;
    }
}