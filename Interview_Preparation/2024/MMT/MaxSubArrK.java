import java.util.*;

public class Solution {
    public static int getLongestSubarray(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        long sum = 0; // Initialize sum with 0
        int maxlen = 0;

        while (r < n) {
            sum += nums[r]; // Update sum
            while (l <= r && sum > k) {
                sum -= nums[l];
                l++;
            }

            if (sum == k) {
                maxlen = Math.max(maxlen, r - l + 1);
            }

            r++;
        }

        if (k == 0 && maxlen == 0) { // Handle case when k = 0 and no subarray sums up to k
            for (int num : nums) {
                if (num == 0) {
                    maxlen = 1;
                    break;
                }
            }
        }

        return maxlen;
    }
}
