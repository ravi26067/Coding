/**
This falls under DP lcs pattern.
Here if both characters are equal we will add and call len-1 for both otherwise we will call max of (len-1 for text1 || len-1 for text2).
*/
class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j] = 1+ dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}
