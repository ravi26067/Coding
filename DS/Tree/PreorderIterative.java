
import java.util.Stack;

/**
 * Iterative class to print preorder traversal of binary tree
 * 1.Create empty stack and push root
 * 2.While stack is not empty:
 * 		a. pop the top as current node from stack and print it
 * 		b. push right then left of current node in stack if they are not null
 * 3.If stack is empty then break
 * 
 * Time complexity is O(n)
 */
public class PreorderIterative {
	
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
	
	public static void preOrder(Node root) {
		
		if(root==null)
			return;
		
		Stack<Node> st = new Stack<>();
		st.push(root);
		
		Node curr =null;
		
		while(!st.empty()) {
			curr = st.pop();
			System.out.print(curr.val+" ");
			
			if(curr.right!=null)
				st.push(curr.right);
			if(curr.left!=null)
				st.push(curr.left);
			
		}
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
		preOrder(root);
	}
	
}
