/**
 * We are checking if x is in left subtree then we will set root.left= deleteNode(root.left) and if its in right subtree then 
 * root.right = deleteNode(root.right). 
 * If we found the node to be deleted equals to root. We have 3 cases:
 * 1) If node has 0 children , then just make root null and return , root.left/root.right = deleteNode will handle it.
 * 2) If node has 1 child, then return that one child. Code will internally handle the deletion.
 * 3) IF node has 2 children, then copy least value of right subtree to current node and delete that node of right subtree using 
 * these steps.
 */
public class DeleteNode {

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
	
	
	static Node findMin(Node root) {
		
		if(root==null)
			return root;
		
		while(root.left!=null)
			root = root.left;
		
		return root;
	}
	
	static Node deleteNode(Node root,int x) {
		
		if(root==null)
			return root;
		else if (x < root.data ) 
			root.left = deleteNode(root.left, x);
		else if (x>root.data)
			root.right = deleteNode(root.right, x);
		else {
			//No child
			if(root.left==null && root.right==null)
				root = null;
			//One child
			else if(root.left ==null) {
				//Node tmp = root;
				root = root.right;
			}
			else if(root.right==null) {
				root = root.left;
			}
			else {
				Node tmp = findMin(root.right);
				root.data = tmp.data;
				root.right = deleteNode(root.right, tmp.data);
			}
		}
		return root;
	}
	
	static void inorder(Node root)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data+ " ");
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(6);
		root.left = new Node(2);
		root.right = new Node(9);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.left.right.left = new Node(3);
		inorder(root);
		System.out.println();
		System.out.println("Min val: "+findMin(root).data);
		deleteNode(root, 4);
		System.out.println("After deletion: ");
		inorder(root);
	}
	
}