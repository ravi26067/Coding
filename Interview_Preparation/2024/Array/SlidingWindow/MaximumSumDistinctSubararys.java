import java.util.HashMap;
import java.util.Map;

public class MaximumSumDistinctSubararys {

    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int n = nums.length;
        long sum = 0;
        long mxSum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            if (mp.containsKey(nums[i])) {
                mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            } else {
                mp.put(nums[i], 1);
            }
        }
        int cnt = 0;
        for (Integer val : mp.values()) {
            if (val > 1) {
                cnt++;
            }
        }

        if (cnt == 0) {
            mxSum = sum;
        }

        for (int i = 1; i <= n - k; i++) {
            if (mp.get(nums[i - 1]) == 1) {
                mp.remove(nums[i - 1]);
            } else if (mp.get(nums[i - 1]) > 1) {
                if (mp.get(nums[i - 1]) == 2) {
                    cnt--;
                }
                mp.put(nums[i - 1], mp.get(nums[i - 1]) - 1);
            }
            sum += nums[i + k - 1] - nums[i - 1];
            // sum += nums[i + k - 1] - nums[i - 1];
            if (mp.containsKey(nums[i + k - 1])) {
                if (mp.get(nums[i + k - 1]) == 1) {
                    cnt++;
                }
                mp.put(nums[i + k - 1], mp.get(nums[i + k - 1]) + 1);
            } else {
                mp.put(nums[i + k - 1], 1);
            }

            if (cnt == 0 && sum > mxSum) {
                mxSum = sum;
            }

        }
        return mxSum;
    }

}
