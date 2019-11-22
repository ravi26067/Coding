/**
 * Class which implements printing reverse of linked list using recursion. Also there is another method which implements logic for
 * reverse of linkedList.
 */
public class ReverseofLinkedList {
	
	
	static class Node{
		int data;
		Node next;
		public Node(int val) {
			data = val;
			next = null;
		}
	}	
	
	//method to print linked list in reverse order
	static void reversePrint(Node node) {
		if(node==null)
			return;
		reversePrint(node.next);
		System.out.print(node.data+ " ");
	}
	
	//method which print linked list
	static void printLL(Node node) {
		while(node!=null) {
			System.out.print(node.data+ " ");
			node = node.next;
		}
		System.out.println();
	}

	static Node reverseLL(Node head) {
		
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
		
	}
	
	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		reversePrint(node);
		System.out.println();
		printLL(node);
		node = reverseLL(node);
		printLL(node);
	}
	
}
