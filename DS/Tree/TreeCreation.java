public class TreeCreation{
	Node root;
	
	static class Node{
		int data;
		Node left,right;
		
		Node(int new_data){
			data = new_data;
			left = right = null;
		}
	}
	
	void insert(int key)
	{
		root = insertrec(root ,key);
	}
	
	Node insertrec(Node root ,int key) {
		
		if(root == null) {
			root = new Node(key);
			return root;
		}
		if(key < root.data)
			root.left = insertrec(root.left , key);
		else if(key > root.data)
			root.right = insertrec(root.right, key);
		return root;
	}
	
	void inorder() {
		inorderrec(root);
		System.out.println();
	}
	
	void inorderrec(Node root) {
		
		if(root!=null) {
			inorderrec(root.left);
			System.out.print(root.data+ " ");
			inorderrec(root.right);
		}
	}
	
	void preorder() {
		preorderrec(root);
		System.out.println();
	}
	
	void preorderrec(Node root) {
		if(root!=null) {
			System.out.print(root.data + " ");
			preorderrec(root.left);
			preorderrec(root.right);
		}
	}
	
	void postorder() {
		postorderrec(root);
		System.out.println();
	}
	
	void postorderrec(Node root) {
		if(root!=null) {
			postorderrec(root.left);
			postorderrec(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	public static void main(String[] args) {
		TreeCreation bst = new TreeCreation();
		bst.insert(3);
		bst.insert(5);
		bst.inorder();
		bst.insert(8);
		bst.insert(2);
		bst.inorder();
		bst.preorder();
		bst.postorder();
	}
}