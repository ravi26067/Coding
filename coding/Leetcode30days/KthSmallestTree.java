
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

/**
 * @author ravik
 * We have to find the kth smallest element in the binary search tree. Here we will use inroder traversal as it will give us the data in increasing order for BST.
 * We will take an array nums to store the index and data for the inorder travarsal value. When index will be equal to k then we will return nums[1].
 */

public class KthSmallestTree {

	public int kthSmallest(TreeNode root, int k) {
		int nums[] = new int[2];
		
		inorder(root,nums,k);
		
		return nums[1];
	}

	private void inorder(TreeNode root, int[] nums, int k) {
		
		if(root==null)
			return;
		
		inorder(root.left, nums, k);
		if(++nums[0] == k) {
			nums[1] = root.val;
			return;
		}
		inorder(root.right, nums, k);
	}

	public static void main(String[] args) {

	}
}
