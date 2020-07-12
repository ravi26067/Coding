import java.util.ArrayList;
import java.util.List;

/**
 * Here we are generating solution from solution itself. We have initialized
 * list of list with empty list and we are adding each number to the already
 * existing sublists.
 */
class Solution {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		ans.add(new ArrayList<>());

		for (int num : nums) {
			List<List<Integer>> helper = new ArrayList<>();

			for (List<Integer> curr : ans) {
				List<Integer> temp = new ArrayList<Integer>(curr);
				temp.add(num);
				helper.add(temp);
			}

			for (List<Integer> curr : helper)
				ans.add(curr);

		}

		return ans;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int arr[] = { 1, 2, 3 };
	}

}