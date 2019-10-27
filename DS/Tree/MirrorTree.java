public class MirrorTree {
	
	private Node root;
	
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
	
	public Node mirrorTree(Node root) {
		
		if(root!=null) {
			Node root1 = new Node(root.val);
			root1.left = mirrorTree(root.right);
			root1.right = mirrorTree(root.left);
			return root1;
		}
		else
			return null;
	
	}
	
	public boolean isMirror(Node root,Node root1) {
		
		if(root!=null && root1!=null) {
			if(root.val == root1.val)
				return isMirror(root.left, root1.right) && isMirror(root.right, root1.left);
			else
				return false;
		}
		else if(root == null && root1 == null)
			return true;
		else
			return false;
	}
	
	void inorder(Node root) {
		if(root!=null) {
			inorder(root.left);
			System.out.print(root.val + " ");
			inorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		MirrorTree mt = new MirrorTree();
		mt.root = new Node(2);
		mt.root.left = new Node(4);
		mt.root.left.right = new Node(7);
		mt.root.left.left = new Node(5);
		mt.root.right = new Node(3);
		mt.root.right.right = new Node(6);
		mt.inorder(mt.root);
		Node root1 = mt.mirrorTree(mt.root);
		System.out.println();
		mt.inorder(root1);
		System.out.println();
		System.out.println(mt.isMirror(mt.root, root1));
	}

}
