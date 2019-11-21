import java.util.Stack;

public class SpiralLevelOrder {

	static class Node{
		int data;
		Node left,right;
		
		public Node(int val) {
			data = val;
			left = right = null;
		}
	}
	
	static void printSpiral(Node root) {
		if(root==null)
			return;
		Node curr = root;
		
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		
		s1.add(curr);
		
		while(!s1.isEmpty() || !s2.isEmpty()) {
			
			while(!s1.isEmpty()) {
				
				curr = s1.pop();
				
				if(curr.right!=null)
					s2.add(curr.right);
				if(curr.left!=null)
					s2.add(curr.left);
				
				
				System.out.print(curr.data + " ");
				
			}
			
			while(!s2.isEmpty()) {
				
				curr = s2.pop();
				
				if(curr.left!=null)
					s1.add(curr.left);
				if(curr.right!=null)
					s1.add(curr.right);
				
				System.out.print(curr.data + " ");
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		printSpiral(root);
	}
	
	
	
}
