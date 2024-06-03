import java.util.HashMap;
import java.util.Map;

public class MinOperationToMakeArrayEmpty {

}

class Solution {
    // https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/description/
    public int minOperations(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int val : nums) {
            if (frequency.containsKey(val)) {
                frequency.put(val, frequency.get(val) + 1);
            } else {
                frequency.put(val, 1);
            }
        }
        int res = 0;
        for (Integer en : frequency.keySet()) {
            int count = frequency.get(en);
            if (count < 2) {
                res = -1;
                break;
            } else if (count % 3 == 0) {
                res += count / 3;
            } else if (count == 2) {
                res += count / 2;
            } else {
                res += count / 3;
                res++;
            }
        }
        return res;
    }
}