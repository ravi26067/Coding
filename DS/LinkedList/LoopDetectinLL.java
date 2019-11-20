package linkedLists;

/**
 *	Class to detect and remove loop in linked list
 */
public class LoopDetectinLL {

	static class Node{
		int data;
		Node next;
		
		public Node(int val) {
			data = val;
			next =null;
		}
	}
	
	static void printLLNode(Node head) {
		System.out.println("Printing Linkedlist nodes:");
		while(head!=null) {
			System.out.print(head.data+ " ");
			head = head.next;
		}
		System.out.println();
	}
	
	
	static boolean detectLoop(Node head) {
		Node ptr1=head,ptr2 = head;
		while(ptr1.next!=null && ptr2.next.next!=null)
		{
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
			if(ptr1==ptr2)
				return true;
		}
		return false;
	}
	
	static void removeLoop(Node head) {
		Node ptr1=head,ptr2 = head;
		int cnt =0;
		while(ptr1.next!=null && ptr2.next.next!=null)
		{
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
			if(ptr1==ptr2)
				break;
		}
		ptr1 =ptr1.next;
		cnt++;
		while(ptr1!=ptr2)
		{
			ptr1 = ptr1.next;
			cnt++;
		}
		System.out.println("Total nodes in loop: " + cnt);
		ptr1 = head;
		while(ptr1!= ptr2){
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		while(ptr1.next!=ptr2)
			ptr1 = ptr1.next;
		
		ptr1.next = null;
	}
	
	public static void main(String[] args) {
		Node head = new Node(4);
		head.next = new Node(6);
		head.next.next = new Node(2);
		head.next.next.next = new Node(8);
		head.next.next.next.next = new Node(10);
		head.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next = head.next.next;
		System.out.println("Loop detected is: " + detectLoop(head));
		if(detectLoop(head))
			removeLoop(head);
		System.out.println("Loop detected is: " + detectLoop(head));
		printLLNode(head);
	}

}
