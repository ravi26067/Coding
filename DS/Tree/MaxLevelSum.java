import java.util.LinkedList;
import java.util.Queue;

/**
 * We are given a tree and we need to find the maximum level sum. Here we are using queue and traversing just like we did for
 * level-order traversal. 
 */
public class MaxLevelSum {

	
	static class Node{
		int data;
		Node left,right;
		
		public Node(int val) {
			data = val;
			left = null;
			right = null;
		}
	}
	
	public static int findMaxSum(Node root) {
		Node curr = root;
		int sum = 0;
		int maxSum = 0;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(curr);
		q.add(null);
		
		while(!q.isEmpty()) {
			curr = q.remove();
			if(curr==null) {
				//logic to get maximum sum by getting sum of each level and comparing with maxSum
				if(maxSum<sum)
					maxSum = sum;
				
				sum = 0;
				
				//terminating condition
				if(!q.isEmpty())
					q.add(null);
			}
			else {
				//logic to store child nodes of current node in queue
				sum += curr.data;
				if(curr.left!=null)
					q.add(curr.left);
				if(curr.right!=null)
					q.add(curr.right);
			}
		}
		return maxSum;
	}
	
	
	public static void main(String[] args) {
		Node tree = new Node(5);
		tree.left = new Node(2);
		tree.right = new Node(17);
		tree.left.left = new Node(4);
		tree.left.right = new Node(6);
		tree.right.right = new Node(13);
		System.out.println("Maximum level sum is: " +findMaxSum(tree));
	}
	
}
