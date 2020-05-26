import java.util.HashMap;
import java.util.Map;

/**
 * @author ravik
 * Here we are taking hashmap to find the max array length with equal number of 0's and 1's. Here we are decreasing count by 1 if it contain 0 and increase if its 1.
 * So whenever we get same key present in hashmap, we will check the difference with previous is greater than max_length otherwise we will add it in the map. 
 */
public class ContiguousArray {

	public int findMaxLength(int[] nums) {
		int maxLen = 0;
		int count = 0;
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		mp.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			count += (nums[i] == 0) ? -1 : +1;

			if (mp.containsKey(count))
				maxLen = Math.max(maxLen, i - mp.get(count));
			else
				mp.put(count, i);

		}
		return maxLen;
	}

	public static void main(String[] args) {
		ContiguousArray ul = new ContiguousArray();
		int A[] = { 1, 0, 0, 1, 0, 1};
		System.out.println(ul.findMaxLength(A));
	}
}
