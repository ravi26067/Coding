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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
		
        if(root==null)
            return ans;
			
        traverse(root,ans,true);
        return ans;
    }
	
    public void traverse(TreeNode root,List<List<Integer>> ans,boolean flag){
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            LinkedList<Integer> res = new LinkedList<>();
            int size = queue.size();
			
            while(size-->0){
			
                TreeNode temp = queue.poll();
                if(!flag == true){
                    res.addFirst(temp.val);        // Add at the 0th Index  O(1)
                }else{ 
                   res.add(temp.val);              // Add at the current index. O(1)
                }
				
                if(temp.left!=null)
                    queue.add(temp.left);      
                if(temp.right!=null)
                    queue.add(temp.right);
                
            }
            flag = !flag ;                         // Inverse the flag.
            ans.add(res);                          // Add the temporary result to actual answer.
        }
    }
}
