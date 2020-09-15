class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int ans[] = new int[len];
        for(int i= len-1;i>-1;i--){
            if(i==len-1 || i==len-2)
                ans[i] = nums[i];
            else{
                int tmp = Math.max((ans[i+1]-nums[i+1]),ans[i+2]);
                //System.out.println(i+ " temp: " + tmp);
                ans[i] = nums[i] + tmp;
            }
        }
        
        // for(int i=0;i<len;i++){
        //     System.out.println(ans[i]);
        // }
        if(len==0)
            return 0;
        else if(len == 1){
            return ans[0];
        }else{
           return Math.max(ans[0],ans[1]); 
        }
    }
}