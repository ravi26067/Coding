class Solution {
    public int maxProduct(int[] nums) {
        int tmpMax=nums[0],tmpMin=nums[0],ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int currMx = tmpMax;
            tmpMax = Math.max(nums[i],Math.max(nums[i]*currMx,nums[i]*tmpMin))%Integer.MAX_VALUE;
            tmpMin = Math.min(nums[i],Math.min(nums[i]*currMx,nums[i]*tmpMin));
            ans = Math.max(ans,tmpMax);
        }
        return ans;
    }
}
