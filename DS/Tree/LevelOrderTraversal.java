package tree;

import java.util.LinkedList;
import java.util.Queue;

import tree.MirrorTree.Node;

public class LevelOrderTraversal {

	private Node root;
	
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
	
	
	public static int height(Node root) {
		
		if(root == null)
			return 0;
		else {
			int lheight = height(root.left);
			int rheight = height(root.right);
			
			if(lheight < rheight)
				return rheight+1;
			else
				return lheight +1;
		}
	}
	
	public static void printLvlOrderRecurssion(Node root) {
		
		int height = height(root);
		for(int i =0;i<=height;i++) {
			printGivenLevel(root, i);
			System.out.println();
		}
		
	}
	
	public static void printGivenLevel(Node root,int level) {
		
		if(root==null)
			return;
		if (level == 1)
			System.out.print(root.val+" ");
		else {
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
		
	}
	
	//without recursion
	public static void printLevelOrder(Node root) {
		Queue<Node> q1 = new LinkedList<Node>();
		q1.add(root);
		q1.add(null);
		while(true) {
			
			Node curr = q1.remove();
			
			if(curr == null) {
				
				if(q1.isEmpty())
				{
					System.out.println();
					break;
				}
				
				System.out.println();
				q1.add(curr);
			}
			else {
				if(curr.left!=null) {
					//System.out.println("Adding node: "+curr.left.val);
					q1.add(curr.left);
				}
				if(curr.right!=null) {
					//System.out.println("Adding node: "+curr.right.val);
					q1.add(curr.right);
				}
				System.out.print(curr.val+" ");
			}
			
		}
	}
	
	public static void main(String[] args) {
		LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal(); 
		levelOrderTraversal.root = new Node(6);
		levelOrderTraversal.root.left = new Node(2);
		levelOrderTraversal.root.right = new Node(9);
		levelOrderTraversal.root.left.left = new Node(1);
		levelOrderTraversal.root.left.right = new Node(4);
		levelOrderTraversal.root.left.right.left = new Node(3);
		levelOrderTraversal.root.right.left = new Node(7);
		levelOrderTraversal.root.right.right = new Node(11);
		levelOrderTraversal.root.right.right.left = new Node(10);
		System.out.print("Without Recurssion:");
		printLevelOrder(levelOrderTraversal.root);
		System.out.print("Recurssion:");
		printLvlOrderRecurssion(levelOrderTraversal.root);
	}

}
