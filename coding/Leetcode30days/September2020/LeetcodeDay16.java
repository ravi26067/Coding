class Solution {
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length ;j++){
                int tmp = nums[i] ^ nums[j];
                if( ans < tmp )
                    ans = tmp; 
            }
        }
        return ans;
    }
}