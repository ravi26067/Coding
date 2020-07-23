import java.util.HashMap;
import java.util.Map;

/**
 * Here we are using map to maintain the frequency of the number and returning
 * the numbers with one frequency.
 */
class Solution {

	public int[] singleNumber(int[] nums) {
		Map<Integer, Integer> mp = new HashMap();
		int res[] = new int[2];
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!mp.containsKey(nums[i])) {
				mp.put(nums[i], 1);
			} else {
				mp.put(nums[i], mp.get(nums[i]) + 1);
			}
		}
		for (Map.Entry<Integer, Integer> m : mp.entrySet()) {
			if (m.getValue() == 1)
				res[j++] = m.getKey();

			if (j == 2)
				break;
		}

		return res;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
	}

}
