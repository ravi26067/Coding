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
 
 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new LinkedList();
		Stack<TreeNode>st1  = new Stack();
		Stack<TreeNode>st2  = new Stack();
		if(root==null)
			return ans;
		st1.add(root);
		LinkedList<Integer> tmp = null;
		while(true) {
			tmp = new LinkedList<Integer>();
			while(!st1.isEmpty()) {
				root = st1.pop();
				tmp.add(root.val);
				if(root.left!=null)
					st2.push(root.left);
				if(root.right!=null)
					st2.push(root.right);
			}
			ans.add(tmp);
			tmp = new LinkedList<Integer>();
			
			while(!st2.isEmpty()) {
				root = st2.pop();
				tmp.add(root.val);
				if(root.right!=null)
					st1.push(root.right);
				if(root.left!=null)
					st1.push(root.left);
			}
			
			ans.add(tmp);
			tmp = new LinkedList<Integer>();
			
			if(st1.isEmpty() && st2.isEmpty())
				break;
		}
		return ans;
	}
 
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
