import java.util.HashMap;

/**
 * In this problem we are using hashmap to store the index against the value of
 * nums[i]. If we find the diff already present in the map we will return i and
 * value of diff.
 */
public class Solution {

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> mp = new HashMap();
		int ans[] = new int[2];

		for (int i = 0; i < nums.length; i++) {
			Integer diff = target - nums[i];
			if (mp.containsKey(diff)) {
				ans[0] = mp.get(diff);
				ans[1] = i;
				return ans;
			} else {
				mp.put(nums[i], i);
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int nums[] = { 3, 2, 4 };
		int target = 6;
		int ans[] = sol.twoSum(nums, target);
		System.out.println(ans[0] + " , " + ans[1]);
	}

}