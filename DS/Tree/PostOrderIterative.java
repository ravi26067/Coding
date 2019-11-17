
import java.util.Stack;

/**
 * 1.Push root to first stack
 * 2.Loop while first stack is not empty
 * 		a. pop a node from 1st stack and push to second stack
 * 		b. push left and right child of popped node to first stack
 * 3.Print contents of second stack
 */
public class PostOrderIterative {
	
	static class Node{
		int val;
		Node left;
		Node right;
		
		public Node(int data) {
			val = data;
			left = null;
			right = null;
		}
	}
	
	public static void postOrderIterative(Node root) {
		
		if(root ==null)
			return;
		
		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();
		Node curr = null;
		st1.push(root);
		
		while(!st1.empty()) {
			
			curr = st1.pop();
			
			st2.push(curr);
			
			if(curr.left!=null)
				st1.push(curr.left);
			if(curr.right!=null)
				st1.push(curr.right);
		}
		
		while(!st2.empty()) 
			System.out.print(st2.pop().val+ " ");
			
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(2);
		root.right = new Node(9);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.left.right.left = new Node(3);
		root.right.left = new Node(7);
		root.right.right = new Node(11);
		root.right.right.left = new Node(10);
		postOrderIterative(root);
	}
	
}
