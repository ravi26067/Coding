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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> que = new LinkedList();
        List<Integer> ans = new ArrayList();
        if(root1!=null)
            que.add(root1);
        que.add(null);
        while(!que.isEmpty()){
            TreeNode tmp = que.remove();
            
            if(tmp!=null){
                ans.add(tmp.val);
                if(tmp.left!=null)
                    que.add(tmp.left);
                if(tmp.right!=null)
                    que.add(tmp.right);
            }else{
                if(que.isEmpty()){
                    break;  
                }
                que.add(null);
            }
        }
        que = new LinkedList();
        if(root2!=null)
            que.add(root2);
        que.add(null);
        while(!que.isEmpty()){
            TreeNode tmp = que.remove();
            
            if(tmp!=null){
                ans.add(tmp.val);
                if(tmp.left!=null)
                    que.add(tmp.left);
                if(tmp.right!=null)
                    que.add(tmp.right);
            }else{
                if(que.isEmpty()){
                    break;  
                }
                que.add(null);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}