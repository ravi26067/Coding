import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class LeetcodeContest {
	
	int isGood(TreeNode root,int max) {
		if(root==null)
			return 0;
		if(root.val >= max)
			return 1+ isGood(root.left, root.val) + isGood(root.right, root.val);
		else
			return isGood(root.left, max) + isGood(root.right, max);
	}

	public int goodNodes(TreeNode root) {
		if(root==null)
			return 0;
		int cnt = 1;
		int l = isGood(root.left, root.val);
		int r = isGood(root.right, root.val);
		cnt += l + r;
		return cnt;
	}
}
