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
    
    public TreeNode buildTreeUtil(int[] post, int idx, int si, int ei, Map<Integer, Integer> mp) {
        
        if (si>ei) return null;
        TreeNode root = new TreeNode(post[idx]);

        int mid = mp.get(post[idx]);
        idx--;

        root.right = buildTreeUtil(post, idx, mid+1, ei, mp);
        root.left = buildTreeUtil(post, idx-(ei-mid), si, mid-1, mp);
        return root;
    }

    public TreeNode buildTree(int[] in, int[] post) {
        
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int i=0; i<in.length; i++) mp.put(in[i], i);
        return buildTreeUtil(post, post.length-1, 0, in.length-1, mp);
        
    }
}
