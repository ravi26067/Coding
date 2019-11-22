/**
 * Height of tree without recursion
 * 1. Take empty queue and push root
 * 2. initialise height as 0
 * 3. in an infinite loop:take nodecount for current level i.e equal to size of queue
 * 		a. increase height by 1 and if nodecount=0 then return height(breaking condition)
 * 		b. while nodecount>0 i.e queue has elements(current level count) : pop and make it as curr node and keep pushing the left and right of curr node 
 * 			element of queue to stack if not null and decrease nodecount by 1
 */
public class Height {

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
	
	
	
	static int heightRec(Node root) {
		
		if(root==null)
			return -1;
		
		int lheight = heightRec(root.left)+1;
		int rheight = heightRec(root.right)+1;
		
		return (lheight>rheight)?lheight:rheight;
		
	}
	
	static int height(Node root) {
		
		
		Queue<Node> q1 = new LinkedList<>();
		Node curr = null;
		int height =0;
		
		q1.add(root);
		
		while(true) {
			
			int nodecount = q1.size();
			if(nodecount==0)
				return height;
			
			height++;
			
			while(nodecount>0) {
				curr = q1.remove();
				if(curr.left!=null)
					q1.add(curr.left);
				if(curr.right!=null)
					q1.add(curr.right);
				nodecount--;
			}
			
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(2);
		root.right = new Node(9);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.left.right.left = new Node(3);
		root.right.left = new Node(7);
		root.right.right = new Node(11);
		root.right.right.left = new Node(10);
		System.out.println("Height of tree is: "+height(root));
		System.out.println("Height of tree using recursion: "+ heightRec(root));
	}
}
