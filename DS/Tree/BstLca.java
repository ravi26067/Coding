
/**
 * Class implements the logic to find LCA in BST and we are assuming that n1 and n2 will be present in BST.
 * 1)Iterate and check if n1 and n2 is on left side then set root = root.left and iterate
 * 2)if n2 and n2 is larger then root then set root = root.right and iterate
 * 3) if root is between n1 and n2 then we break and return the root.
 */
public class BstLca {
	
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
	
	
	static Node LCA(Node root,int n1,int n2) {
		
		while(root!=null)
		{
			if(root.val > n1 && root.val > n2)
				root = root.left;
			else if(root.val < n1 && root.val < n2)
				root = root.right;
			else
				break;
			
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(22);
		root.left = new Node(15);
		root.right = new Node(25);
		root.left.left = new Node(8);
		root.left.right = new Node(17);
		root.left.left.left = new Node(6);
		root.left.left.right = new Node(14);
		root.right.right = new Node(29);
		System.out.println("LCA of bst is: "+ LCA(root, 6, 17).val);
		
	}
	
}
