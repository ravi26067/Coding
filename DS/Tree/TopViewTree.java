
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;



/**
 * Class created to print top view of tree. We are taking here TreeMap as it sorts based on its key. We are taking distance from
 * root as key and if it already exists we wont put it in the map. We are using queue for storing nodes as we do in level order
 * with distance(indx) field so we will traverse until we get null.
 */
public class TopViewTree {
	
	static class Node{
		
		int data;
		Node left,right;
		
		public Node(int val) {
			data = val;
			left = right = null;
		}
		
	}
	
	static void printTop(Node root) {
		
		if(root==null)
			return;
		
		class Pair{
			Node node;
			int indx;
			
			public Pair(Node node,int indx) {
				this.node = node;
				this.indx = indx;
			}
		}
		
		Queue<Pair> q1 = new LinkedList<Pair>();
		Map<Integer,Node> m1 = new TreeMap<Integer,Node>();
		
		Pair tmpCurr = new Pair(root, 0);
		q1.add(tmpCurr);
		
		while(!q1.isEmpty()) {
			
			tmpCurr = q1.remove();
			
			if(!m1.containsKey(tmpCurr.indx)) 
				m1.put(tmpCurr.indx, tmpCurr.node);
			
			if(tmpCurr.node.left!=null) {
				q1.add(new Pair(tmpCurr.node.left,tmpCurr.indx - 1));
			}
			
			if(tmpCurr.node.right!=null)
				q1.add(new Pair(tmpCurr.node.right, tmpCurr.indx +1));
		}
		
		for(Entry<Integer, Node> entry: m1.entrySet())
			System.out.print(entry.getValue().data + " ");
		
		System.out.println();
		
	}
	
	
	
	static void inorder(Node root) {
		if(root!=null) {
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(5);
		root.left.right.right.right = new Node(6);
		//inorder(root);
		printTop(root);
	}
}
