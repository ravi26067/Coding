package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *	Class to print alternate level of binary tree.
 */
public class PrintAlternateNodes {

	static class Node{
		int data;
		Node left,right;
		
		public Node(int val) {
			data = val;
			left = null;
			right = null;
		}
	}
	
	
	//using two stacks
	public static void printAlternateLevelNodes(Node root) {
		
		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();
		
		Node curr = root;
		
		if(root==null)
			return;
		
		st1.push(curr);
		
		while(!st1.isEmpty()|| !st2.isEmpty()) {
			
			while(!st1.isEmpty()) {
				curr = st1.pop();
				System.out.print(curr.data+ " ");
				if(curr.left!=null)
					st2.push(curr.left);
				if(curr.right!=null)
					st2.push(curr.right);
			}
			while(!st2.isEmpty()) {
				curr = st2.pop();
				if(curr.left!=null)
					st1.push(curr.left);
				if(curr.right!=null)
					st1.push(curr.right);
			}
			
		}
		System.out.println();
		
	}
	
	// using level order traversal approach by using queue
	public static void printAlternateNode(Node root){
		
		Queue<Node> queue = new LinkedList<Node>();
		
		Node curr = root;
		
		if(root==null)
			return;
		
		int cnt = 1;
		queue.add(curr);
		queue.add(null);
		
		while(!queue.isEmpty()) {
			
			curr = queue.remove();
			
			if(cnt%2==1 && curr!=null)
				System.out.print(curr.data+" ");
			
			if(curr==null) {
				cnt++;
				if(!queue.isEmpty())
					queue.add(curr);
			}
			else
			{
				if(curr.left!=null)
					queue.add(curr.left);
				if(curr.right!=null)
					queue.add(curr.right);
			}
			//System.out.println();
		}
		System.out.println();
		
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.left.left.left.right = new Node(20);
		printAlternateNode(root);
		System.out.println("Using two stacks");
		printAlternateLevelNodes(root);
	}

}
