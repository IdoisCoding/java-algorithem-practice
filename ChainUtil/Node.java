public class Node<T> {
	
	private T value;
	private Node<T> next;
	
	public Node (T value)
	{
		this.value=value;
		this.next= null;
	}
	
	public Node(T value, Node<T> next)
	{
		this.value = value;
		this.next= next;
	}
	
	public boolean hasNext()
	{
		return (this.next!=null);
	}
	
	public void setValue(T x)
	{
		this.value = x;
	}
	
	public void setNext(Node<T> next)
	{
		this.next = next;
	}
	
	public Node<T> getNext()
	{
		return this.next;
	}
	
	public T getValue()
	{
		return this.value;
	}
	public String toString()
	{
		return this.getValue().toString();
	}
}
