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
	
	
	public void push(int new_data){
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}
	
	
	public void insertAfter(Node prev_node , int data){
		Node new_node = new Node(data);
			
		if(prev_node == null){
			System.out.println("prev node can't be null.");
			return;
		}
		new_node.next = prev_node.next;
		prev_node.next = new_node;
		return;
	}
	
	public void append(int new_data){
		Node new_node = new Node(new_data);
		if(head == null){
			head = new_node;
			return;
		}
		
		Node last = head;
		while (last.next != null)
			last = last.next;
		
		last.next = new_node;
		return;
	}
	
	public void printList(){
		Node n = head;
		while(n!=null){
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
	
	public static void main(String [] args){
		
		LinkedListCreation llst = new LinkedListCreation();
		llst.append(5);
		llst.printList();
		llst.insertAfter(llst.head.next, 10);
		llst.printList();
		llst.insertAfter(llst.head, 10);
		llst.printList();
		llst.insertAfter(llst.head.next, 20);
		llst.printList();
		llst.push(13);
		llst.printList();
	}
}