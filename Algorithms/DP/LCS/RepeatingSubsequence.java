//User function Template for Java

class Solution
{
  /**
  * Its just a variation of LCS, here just we need to check if both of the index should not be equal then only we will consider that.
  * We have only one string which we will compare with itself.
  */
    int dp[][];
    public int LongestRepeatingSubsequence(String str)
    {
        int m = str.length();
        
        dp = new int[m+1][m+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(str.charAt(i-1)==str.charAt(j-1) && i!=j)
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][m];
    }
}
