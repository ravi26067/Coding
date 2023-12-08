package programming.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> valueMp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (valueMp.containsKey(target - nums[i])) {
                ans[0] = valueMp.get(target - nums[i]);
                ans[1] = i;
                break;
            }
            valueMp.put(nums[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 2, 4 };
        int target = 6;
        TwoSum ts = new TwoSum();
        int[] res = ts.twoSum(nums, target);
        System.out.println(res[0] + " : " + res[1]);
    }
}
