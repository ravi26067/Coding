
public class DistanceofNode {

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
	
	
	static int nodeDistance(Node root, int x) {
		
		if(root==null)
			return -1;
		
		int dis = -1;
		
		if((root.data == x) || 
				(dis = nodeDistance(root.left, x)) >=0 ||
				(dis = nodeDistance(root.right, x)) >=0)
			return dis+1;
		
		return dis;
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println("Distance of node: "+ nodeDistance(root, 2));
	}
	
}
