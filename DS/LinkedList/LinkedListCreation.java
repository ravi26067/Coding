class LinkedListCreation{
	Node head;
	
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}//constructor
	}
	
	public void printList(){
		Node n = head;
		while(n!=null){
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	public static void main(String [] args){
		
		LinkedListCreation llst = new LinkedListCreation();
		llst.head = new Node(2);
		Node second = new Node(4);
		Node third = new Node(7);
		
		llst.head.next = second;
		second.next = third;
		
		llst.printList();
	}
}