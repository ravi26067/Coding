/**
 * @author ravik
 * Here we are using dynamic programming. Here is link where you can understand this problem.
 * https://www.youtube.com/watch?v=ZkgBinDx9Kg
 */
public class EditDistance {

	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int [][] dp = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0)
					dp[i][j] = j;
				else if(j==0)
					dp[i][j] = i;
				else {
					if(word1.charAt(i-1)==word2.charAt(j-1))
						dp[i][j] = dp[i-1][j-1];
					else
						dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		String word1 = "horse";
		String word2 = "ros";
		System.out.println(ed.minDistance(word1, word2));
	}

}
