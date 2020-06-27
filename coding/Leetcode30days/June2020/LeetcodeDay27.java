/**
 * Here we are using recursion. We are checking for every possible square root
 * and checking with the value of answer and correspondingly we are updating the
 * value of n in recursion.
 */
public class Solution {

	int ans;

	private void squares(int n, int curr) {

		int sq = (int) Math.sqrt(n);

		if (ans < curr + 1)
			return;

		if (sq * sq == n) {
			if (curr + 1 < ans)
				ans = curr + 1;
			return;
		}

		for (int i = sq; i > 0; i--) {
			squares(n - (i * i), curr + 1);
		}

	}

	public int numSquares(int n) {
		if (n == 0)
			return 0;
		ans = Integer.MAX_VALUE;
		squares(n, 0);

		return ans;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.numSquares(16));
	}

}