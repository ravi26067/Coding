import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Here we have to print reverse of the level order of tree. We are using Stack
 * to store the level and we are storing it later in list so that it will give
 * reverse level order of tree.
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

public class Solution {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Stack<List<Integer>> stRes = new Stack<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null)
			return res;
		queue.add(root);
		queue.add(null);
		List<Integer> tmp = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode temp = queue.remove();
			if (temp == null) {
				if (!queue.isEmpty()) {
					queue.add(null);
				}
				stRes.add(tmp);
				tmp = new ArrayList<Integer>();
			} else {
				tmp.add(temp.val);
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}

		while (!stRes.isEmpty()) {
			res.add(stRes.pop());
		}

		return res;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
	}

}