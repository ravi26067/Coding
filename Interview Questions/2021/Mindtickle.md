# Round 1

## Q1: 

https://leetcode.com/problems/generate-parentheses/ 
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        getParanthesis("",2*n,0,res);
        return res;   
    }
    
    public void getParanthesis(String s,int k,int n,List<String>res){
        if(k==0){
            res.add(s);
        }
        if(n<k){
            getParanthesis(s+"(",k-1,n+1,res);
            if(k>0){
                getParanthesis(s+")",k-1,n-1,res);
            }
            
        }
    }
}

## Q2:
  
https://leetcode.com/problems/binary-tree-maximum-path-sum/

class Solution {
    public int maxPathSum(TreeNode root) {
        
        if(root.left==null && root.right==null)
            return root.val;
        
        int left = 0;
        
        if(root.left!=null){
            left = maxPathSum(root.left);
        }
        
        int right = 0;
        
        if(root.right!=null){
            right = maxPathSum(root.right);
        }
        if(root.left==null ){
            return Math.max(root.val,Math.max(root.val+right,right));
        }
        
        if(root.right==null ){
            return Math.max(root.val,Math.max(root.val+left,left));
        }
        
        return Math.max(left+right+root.val,Math.max(root.val,Math.max(left,right)));
    }
}

