class Solution {
  
  /**
  * Cousins should be in same level and their parents should not be the same.
  */
    
    int level = 0;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<TreeNode> queue = new LinkedList();
        Map<Integer,Integer> nums = new TreeMap();
        queue.add(root);
        queue.add(null);
        
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            
            if(node!=null){
                //nums.put(node.val,null);
                if(node.val==x){
                    if(nums.containsKey(y)){
                        if(nums.get(y)==level)
                            return true;
                        else
                            return false;
                    }
                    nums.put(node.val,level);
                }
                if(node.val==y){
                    if(nums.containsKey(x)){
                        if(nums.get(x)==level)
                            return true;
                        else
                            return false;
                    }
                    nums.put(node.val,level);
                }
                if(node.left!=null && node.right!=null){
                    if((node.left.val==x||node.left.val==y) && (node.right.val==x || node.right.val==y))
                        return false;
                }
                
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }else{
                level++;
                if(queue.isEmpty())
                {
                        /*
                        if(nums.containsKey(x)&&nums.containsKey(y))
                        {
                            return true;
                        }else if(nums.containsKey(x) || nums.containsKey(y)){
                            return false;
                        }
                        */
                    return false;
                }
                queue.add(null);
                /*
                if(nums.containsKey(x)&&nums.containsKey(y))
                {
                    return true;
                }else if(nums.containsKey(x) || nums.containsKey(y)){
                    return false;
                }
                nums = new HashMap();
                */
            }
        }
        
        return false;
    }
}
