
import java.util.Stack;

/**
 * This class contains methods for inorder traversal without recursion.
 * Algorithm
 * --------------
 * 1. Create Empty Stack s
 * 2. Initialize current node as root node
 * 3. Push current node to s and curr = curr.left until curr becomes null
 * 4. if curr=null and s is not empty
 * 		1. pop the top
 * 		2. print current node and set curr = curr.right
 * 		3. go to step 3
 * 5. if curr = null and s is empty we are done
 * 
 * Time complexity is O(n) 
 */
public class InorderTraversal {
	
	
	public static void inorder(Node root) {
		
		Stack<Node> sq = new Stack<Node>();
		
		Node curr = root;
		boolean done = true;
		while(done) {
			
			if(curr!=null) {
				sq.add(curr);
				curr = curr.left;
			}
			else {
				if(!sq.empty()) {
					curr = sq.pop();
					System.out.print(curr.val+" ");
					curr = curr.right;
				}
				else
					done = false;
			}
			
		}
		System.out.println();
		
	}

	static class Node{
		int val;
		Node left;
		Node right;
		
		public Node(int data) {
			val = data;
		}
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
		inorder(root);
	}

}
