import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Here we are taking queue to store the leftmost value with depth as key and
 * position as value. We are checking the difference with current level and left
 * value at that level with the existing max width.
 */

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

class Solution {
	int maxw;
	HashMap<Integer, Integer> left_pos;

	public void get_width(TreeNode root, int depth, int pos) {
		if (root == null)
			return;
		if (!left_pos.containsKey(depth))
			left_pos.put(depth, pos);

		maxw = Math.max(maxw, pos - left_pos.get(depth) + 1);

		get_width(root.left, depth + 1, pos * 2);
		get_width(root.right, depth + 1, pos * 2 + 1);
	}

	public int widthOfBinaryTree(TreeNode root) {
		maxw = 0;
		left_pos = new HashMap<Integer, Integer>();
		get_width(root, 0, 0);
		return maxw;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
	}

}
