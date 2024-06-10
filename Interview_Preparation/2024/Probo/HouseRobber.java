class Solution {
    public int rob(int[] nums) {
        // Check if the input array is null or empty
        if (nums == null || nums.length == 0) {
            return 0; // If so, return 0 (no houses to rob)
        } else if (nums.length == 1) {
            return nums[0]; // If there's only one house, return the value of that house
        } else {
            int len = nums.length;
            int[] dp = new int[len]; // Array to store the maximum stolen value up to each house

            // Base cases for the first two houses
            dp[0] = nums[0]; // Maximum stolen value for the first house
            dp[1] = Math.max(nums[0], nums[1]); // Maximum stolen value for the second house

            // Iterate through the remaining houses starting from the third one
            for (int i = 2; i < len; i++) {
                // Choose whether to rob the current house or skip it
                // If we rob the current house, add its value to the maximum stolen value from two houses ago
                // If we skip the current house, the maximum stolen value remains the same as the previous house
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            // Return the maximum stolen value from the last house
            return dp[len - 1];
        }
    }
}
