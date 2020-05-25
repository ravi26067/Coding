import java.util.Scanner;



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

/**
 * @author ravik
 * Here we are using recursion where we will be checking the left an right bounds and accordingly we will place the node based on values of left and right bounds.
 */
public class BSTFromPreorder {
	
	int construct_best(int []preorder,int n,int pos,TreeNode curr,int left,int right) {
		
		if(pos==n || preorder[pos] < left || preorder[pos]>right)
			return pos;
		
		if(preorder[pos] < curr.val) {
			curr.left = new TreeNode(preorder[pos], null, null);
			pos+=1;
			pos = construct_best(preorder, n, pos, curr.left, left, curr.val-1);
		}
		
		if(pos==n || preorder[pos] < left || preorder[pos]>right)
			return pos;
		
		curr.right = new TreeNode(preorder[pos], null, null);
		pos+=1;
		pos = construct_best(preorder, n, pos, curr.right, curr.val+1, right);
		return pos;
	}
	
	
	public TreeNode bstFromPreorder(int[] preorder) {
		
		int n =preorder.length;
		if(n==0)
			return null;
		
		TreeNode root = new TreeNode(preorder[0],null,null);
		if(n==1)
			return root;
		
		construct_best(preorder, n, 1, root , Integer.MIN_VALUE, Integer.MAX_VALUE);
		
        return root;
    }
	
	

	public static void main(String[] args) {
		
	}
}
