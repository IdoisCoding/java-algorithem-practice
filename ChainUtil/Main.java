public class Main {
    public static void main(String[] args) {
        chainUtils utils = new chainUtils();
        

        System.out.println("Testing turnToChain:");
        Node<Integer> chain1 = utils.turnToChain();
        printChain(chain1);
     
        System.out.println("\nTesting insert:");
        Node<Integer> chain2 = new Node<>(1);
        chain2.setNext(new Node<>(3));
        chain2.getNext().setNext(new Node<>(5));
        chain2 = utils.insert(chain2, 4);
        printChain(chain2);
        
        System.out.println("\nTesting specialInsert1:");
        Node<Integer> chain3 = new Node<>(2);
        chain3.setNext(new Node<>(4));
        chain3.getNext().setNext(new Node<>(6));
        chain3 = utils.specialInsert1(chain3);
        printChain(chain3);
        
        System.out.println("\nTesting specialInsert2:");
        Node<Integer> chain4 = new Node<>(1);
        chain4.setNext(new Node<>(3));
        chain4.getNext().setNext(new Node<>(5));
        utils.specialInsert2(chain4, 4);
        printChain(chain4);
    }
    
    private static void printChain(Node<?> head) {
        while (head != null) {
            System.out.print(head.getValue() + " -> ");
            head = head.getNext();
        }
        System.out.println("null");
    }
}
