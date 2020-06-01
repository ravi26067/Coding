/**
 * @author ravik 
 * Here we are using dynamic programming as we have m and n as length. So if A[m]==B[n] then we will include that line and move forward otherwise we have to 
 * choose maximum of two possibilities i.e (m-1,n) or (m,n-1). So here the requirements of dynamic programming is getting fulfilled as it has optimal substructure
 * as the subproblems are solved to get result of problems. Also there are overlapping calls so we have to use here dynamic programming.
 */
public class UncrossedLines {

	public int maxUncrossedLines(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int dp[][] = new int[m + 1][n + 1];

		for (int i = 1; i < m + 1; i++)
			for (int j = 1; j < n + 1; j++)
				dp[i][j] = A[i - 1] == B[j - 1] ? 1 + dp[i - 1][j - 1] : Math.max(dp[i][j - 1], dp[i - 1][j]);

		return dp[m][n];
	}

	public static void main(String[] args) {
		UncrossedLines ul = new UncrossedLines();
			int A [] = {1,3,7,1,7,5};
			int B [] = {1,9,2,5,1};
			System.out.println(ul.maxUncrossedLines(A, B));
	}
}
