import java.util.Arrays;

/**
 * Here we are sorting the costs array based on the difference between cost of
 * city A and B. We are using here lambda expressions. Also if we see we will
 * get the minimum difference result in first half which means city A should be
 * selected and in second half city B should be selected.
 */
public class Solution {

	public int twoCitySchedCost(int[][] costs) {
		int len = costs.length;
		int sum = 0;

		Arrays.sort(costs, (a, b) -> {
			return (a[0] - a[1]) - (b[0] - b[1]);
		});

		for (int i = 0; i < len / 2; i++) {
			sum += costs[i][0];
		}

		for (int i = len / 2; i < len; i++) {
			sum += costs[i][1];
		}

		return sum;

	}

	public static void main(String[] args) {
		Solution sl = new Solution();
		int[][] costs = { { 10, 20 }, { 30, 200 }, { 30, 50 }, { 30, 20 } };
		System.out.println(sl.twoCitySchedCost(costs));
	}
}
