/**
 * @author kumarr144
 * This class implements the arrangement of linkedlist in such a way the odd positioned data we will have
 * one side and even positioned at other side just after the odd side data. We are using three reference variable.
 */
public class EvenOdd {

	static Node head;
	
	class Node{
		int data;
		Node next;
		public Node(int val) {
			data = val;
			next = null;
		}
	}
	
	
	public void push(int val) {
		Node new_node = new Node(val);
		new_node.next = head;
		head = new_node;
	}
	
	public void rearrangeEvenOdd() {
		
		Node odd = head;
		Node even = head.next;
		Node even_first = even;
		while(true) {
			
			if(odd==null|| even == null || even.next==null) {
				odd.next = even_first;
				break;
			}
			odd.next = even.next;
			odd = even.next;
			
			if(odd.next==null) {
				even.next = null;
				odd.next = even_first;
				break;
			}
			
			even.next = odd.next;
			even = odd.next;
			
		}
	}
	
	public static void printLL() {
		Node temp = head;
		
		System.out.println("Printing LL ..");
		
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		EvenOdd ll = new EvenOdd();
		ll.push(23);
		ll.push(45);
		ll.push(12);
		ll.push(90);
		ll.push(34);
		printLL();
		ll.rearrangeEvenOdd();
		printLL();
	}

}
