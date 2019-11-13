/**
 * @author kumarr144
 * This class implements the conversion of binary linked list to its decimal value. We are using the 
 * formula ans = 2* ans + linkedList.data , or we can also use bitwise operation.
 */
public class ConvertBinary {

	static Node head;
	
	class Node{
		boolean data;
		Node next;
		public Node(boolean val) {
			data = val;
			next = null;
		}
	}
	
	
	public void push(int val) {
		Node temp = head;
		Node new_node = new Node(val==1?true:false);
		if(temp==null)
			head = new_node;
		else {
			while(temp.next!=null)
				temp= temp.next;
			temp.next = new_node;
		}
	}
	
	public static int convertToInt() {
		Node temp = head;
		int res = 0;
		while(temp!=null) {
			res = res*2 + (temp.data?1:0);
			temp = temp.next;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		ConvertBinary ll = new ConvertBinary();
		ll.push(1);
		ll.push(0);
		ll.push(1);
		ll.push(1);
		System.out.println("Result of binary array: "+convertToInt());
	}

}
