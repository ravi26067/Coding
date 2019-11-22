/**
 * This class implements program to calculate LCA of two nodes. It will first check if n1 or n2 is root ,if yes then it will be LCA 
 * as it is ancestor of other node. If not then check if lca is present in left subtree or right subtree. If n1 and n2 is on either
 * side of current node return current node.
 */
public class LcaOfBinaryTree {
		
	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	static Node findLca(Node root,int n1,int n2) {
		
		if(root==null)
			return root;
		
		if(root.data == n1 || root.data == n2)
			return root;
		
		Node lcaLeft = findLca(root.left, n1, n2);
		Node lcaRight = findLca(root.right, n1, n2);
		
		if(lcaLeft!=null && lcaRight!=null)
			return root;
		
		return (lcaLeft!=null)? lcaLeft : lcaRight;
		
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println("LCA is: " + findLca(root, 4, 7).data);
	}	
}