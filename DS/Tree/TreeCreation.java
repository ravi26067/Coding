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
	
	void delete(int key) {
		root = deletere(root,key);
	}
	
	Node deletere(Node root, int key) {
		
		if(root == null)
			return root;
		else if (root.data > key){
			root.left = deletere(root.left, key);
		}
		else if(root.data < key) {
			root.right = deletere(root.right, key);
		}
		else {
			//leaf node or no node
			if(root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else {
				root.data = minVal(root.right);
				root.right = deletere(root.right, key);
			}
		}
		
		return root;
	}
	
	int minVal(Node root) {
		int minv = root.data;
		while(root.left!=null) {
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}
	
	public static void main(String[] args) {
		TreeCreation bst = new TreeCreation();
		bst.insert(3);
		bst.insert(5);
		bst.insert(8);
		bst.insert(2);
		bst.insert(9);
		bst.insert(13);
		bst.preorder();
		bst.inorder();
		bst.postorder();
		bst.delete(3);
		bst.inorder();
	}
}