/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
		int lvl=0;
		
		int xpar = -1;
		int ypar = -1;
		int xlvl = -1;
		int ylvl = -1;
		
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		if(root.val==x || root.val==y)
			return false;
		else {
			que.add(root);
			que.add(null);
			while(!que.isEmpty()) {
				
				if(xpar!=-1 && ypar!=-1) {
					if(xpar!=ypar && xlvl == ylvl)
						return true;
					else
						return false;
				}
				
				TreeNode temp = que.remove();
				if(temp==null) {
					if(!que.isEmpty()) {
						que.add(null);
						lvl++;
					}
				}else {
					if(temp.left!=null) {
						if(temp.left.val==x || temp.left.val == y) {
							if(xpar==-1) {
								xpar = temp.val;
								xlvl = lvl+1;
							}
							else {
								ypar = temp.val;
								ylvl = lvl+1;
							}
						}
						que.add(temp.left);
					}
					if(temp.right!=null) {
						if(temp.right.val==x || temp.right.val == y) {
							if(xpar==-1) {
								xpar = temp.val;
								xlvl = lvl+1;
							}
							else {
								ypar = temp.val;
								ylvl = lvl+1;
							}
						}
						que.add(temp.right);
					}
				}
			}
			
		}
		return false;
	}
}