public class MergeTrees {
	
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
	
	static void inOrder(Node node) {
		if(node!=null) {
			inOrder(node.left);
			System.out.print(node.val+" ");
			inOrder(node.right);
		}
	}
	
	
	static Node mergeTree(Node node1,Node node2) {
		
		if(node1==null) 
			return node2;
		if(node2==null)
			return node1;
		node1.val +=node2.val;
		node1.left = mergeTree(node1.left, node2.left);
		node1.right = mergeTree(node1.right, node2.right);
		return node1;
		
	}
	
	public static void main(String[] args) {
		Node root1 = new Node(2);
		root1.left = new Node(1);
		root1.right = new Node(4);
		root1.left.left = new Node(5);
		inOrder(root1);
		System.out.println();
		Node root2 = new Node(3);
		root2.left = new Node(6);
		root2.right = new Node(1);
		root2.left.right = new Node(2);
		root2.right.right = new Node(7);
		inOrder(root2);
		System.out.println();
		root1 = mergeTree(root1, root2);
		inOrder(root1);
		System.out.println();
	}
	
}
