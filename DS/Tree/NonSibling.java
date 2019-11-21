
public class NonSibling {

	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int val) {
			data = val;
			left = null;
			right = null;
		}
	}
	
	static void printNonSibling(Node root) {
		
		if(root==null)
			return;
		
		if(root.left!=null&&root.right!=null)
		{
			printNonSibling(root.left);
			printNonSibling(root.right);
		}
		else if(root.left!=null) {
			System.out.print(root.left.data + " ");
			printNonSibling(root.left);
		}
		else if(root.right!=null)
		{
			System.out.print(root.right.data + " ");
		}
		
		
	}
	
	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		printNonSibling(root);
	}
	
}
