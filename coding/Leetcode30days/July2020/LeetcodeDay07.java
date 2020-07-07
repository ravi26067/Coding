/**
 * Here we are checking if we have grid[i][j] as 1 and we will check its
 * neighbors with value 0 or out of bound and we are adding that side to
 * Parameter.
 */

class Solution {

	int ans = 0;

	boolean inBound(int i, int j, int m, int n) {
		if (i >= 0 && j >= 0 && i < m && j < n)
			return true;
		else
			return false;
	}

	void dfs(int grid[][], int i, int j, int m, int n) {

		if (grid[i][j] != 1)
			return;

		grid[i][j] = -1;

		if (inBound(i - 1, j, m, n)) {
			if (grid[i - 1][j] != 0)
				dfs(grid, i - 1, j, m, n);
			else
				ans += 1;
		} else
			ans += 1;

		if (inBound(i + 1, j, m, n)) {
			if (grid[i + 1][j] != 0)
				dfs(grid, i + 1, j, m, n);
			else
				ans += 1;
		} else
			ans += 1;

		if (inBound(i, j - 1, m, n)) {
			if (grid[i][j - 1] != 0)
				dfs(grid, i, j - 1, m, n);
			else
				ans += 1;
		} else
			ans += 1;

		if (inBound(i, j + 1, m, n)) {
			if (grid[i][j + 1] != 0)
				dfs(grid, i, j + 1, m, n);
			else
				ans += 1;
		} else
			ans += 1;

	}

	public int islandPerimeter(int[][] grid) {
		int m = grid.length;
		if (m <= 0)
			return 0;
		int n = grid[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					dfs(grid, i, j, m, n);
					break;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int grid[][] = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(sol.islandPerimeter(grid));
	}

}
