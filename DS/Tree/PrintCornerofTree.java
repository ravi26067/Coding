
import java.util.LinkedList;
import java.util.Queue;

public class PrintCornerofTree {
	
	static class Node{
		int val;
		Node left;
		Node right;
		
		public Node(int data) {
			val = data;
		}
	}
	
	
	static void printCorner(Node root) {
		
		if(root==null)
			return;
		
		Queue<Node> q1= new LinkedList<>();
		
		Node curr = root;
		int cnt = 0;
		q1.add(curr);
		q1.add(null);
		
		while(!q1.isEmpty()) {
			
			curr = q1.remove();
			
			if(curr==null) {				
				cnt = 0;
				if(q1.isEmpty())
					break;
				
				q1.add(null);
				
			}
			else {
				
				if(curr.left!=null)
					q1.add(curr.left);
				if(curr.right!=null)
					q1.add(curr.right);
				cnt++;
				
				if(cnt==1 || q1.peek()==null)
					System.out.print(curr.val + " ");
				
			}
		}
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);
		printCorner(root);
	}
}
