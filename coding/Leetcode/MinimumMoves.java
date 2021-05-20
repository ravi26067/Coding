class Solution {
//median of an array and get minimum moves to make array elements equal
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int median = (n%2==0)? (nums[n/2] + nums[n/2 - 1])/2:nums[n/2];

        int res = 0;
        for(int i=0;i<n;i++)
        {
            res+= Math.abs(nums[i] - median);
        }
        return res;
    }
}
