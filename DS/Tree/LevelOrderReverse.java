
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This class implements logic for reverse of level order traversal from reverse
 * Algorithm
 * 1.Create empty stack and queue
 * 2.Enqueue the root node in queue
 * 3.Loop while queue is not null
 * 		1.dequeue a node from q and make it root
 * 		2.push the root node to stack 
 * 		3.enqueue the root node children to queue (right then left) to q
 * 4.Pop all items from stack one by one and print them.
 *
 * Time complexity will be O(n) 
 */
public class LevelOrderReverse {
	
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
	
	
	public static void reverseLevelOrder(Node root) {
				
		Stack<Node> sq = new Stack<>();
		Queue<Node> queue = new LinkedList<>();
		Node curr = null;
		queue.add(root);
		while(!queue.isEmpty()) {
			curr = queue.remove();
			sq.push(curr);
			if(curr.right!=null)
				queue.add(curr.right);
			if(curr.left!=null)
				queue.add(curr.left);
		}
		while(!sq.empty()) {
			System.out.print(sq.pop().val+" ");
		}
		System.out.println();
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
		reverseLevelOrder(root);
	}
}
