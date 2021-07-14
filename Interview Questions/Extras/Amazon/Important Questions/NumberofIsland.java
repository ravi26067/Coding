/**
 * Graph Data Structure
 * Here we are marking one whole island visited using bfs technique recursively.
 * We are calling the bfs method only when grid value is 1 and its unvisited.
 */
public class Solution {

	//method to check weather the indexes are in range or not
	private boolean inRange(int i, int j, int m, int n) {
		if (i < 0 || i >= m || j < 0 || j >= n)
			return false;
		else
			return true;
	}

	//bfs recursive method 
	private void bfs(char[][] grid, boolean visited[][], int i, int j) {
		visited[i][j] = true;
		int arr[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		for (int a = 0; a < 4; a++) {
			int b = i + arr[a][0];
			int c = j + arr[a][1];
			if (inRange(b, c, grid.length, grid[0].length) && visited[b][c] == false && grid[b][c] == '1') {
				bfs(grid, visited, b, c);
			}
		}
	}

	
	public int numIslands(char[][] grid) {
		int m = grid.length;
		if (m == 0)
			return 0;
		int n = grid[0].length;
		int noi = 0;
		boolean visited[][] = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == false && grid[i][j] == '1') {
					bfs(grid, visited, i, j);
					noi++;
				}
			}
		}
		return noi;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println("Result: " + sol.numIslands(grid));
	}

}