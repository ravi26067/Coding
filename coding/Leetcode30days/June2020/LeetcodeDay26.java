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
    
    class PairT{
        TreeNode node;
        long sum;
        
        PairT(TreeNode nd,long sm){
            node = nd;
            sum = sm;
        }
    }
    
    public int sumNumbers(TreeNode root) {
        Queue<PairT> queue = new LinkedList();
        int sum = 0;
        if(root==null)
            return sum;
        
        queue.add(new PairT(root,root.val));
        queue.add(null);
        
        while(!queue.isEmpty()){
            PairT temp = queue.remove();
            if(temp == null){
                //ystem.out.println();
                if(!queue.isEmpty())
                    queue.add(null);
            }
            else{
                if(temp.node.left==null && temp.node.right==null)
                {
                    sum+=  temp.sum;
                }
                else{
                    //System.out.print(temp.node.val+ " "+ temp.sum +" ");
                    if(temp.node.left!=null){
                        queue.add(new PairT(temp.node.left, (temp.sum *10) + temp.node.left.val));
                    }
                    if(temp.node.right!=null){
                        queue.add(new PairT(temp.node.right,(temp.sum *10) + temp.node.right.val));
                    }
                }
                
            }
        }
        
        return sum;
    }
}



//Recursive and better approach
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
    int sum ;
    
    private void dfs(TreeNode root,int curr){
        
        if(root==null)
            return;
        curr = 10*curr + root.val;
        if(root.left==null&& root.right==null){
            sum += curr;
            return;
        }
        else{
            dfs(root.left,curr);
            dfs(root.right,curr);
        }
    }
    
    public int sumNumbers(TreeNode root) {
        sum = 0;
        dfs(root,0);
        return sum;
    }
}