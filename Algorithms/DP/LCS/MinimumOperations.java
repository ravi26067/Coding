class Solution {
    /* this problem is similar to shortest common supersequence 
    * there the formula was l1+l2 - LCS
    * not it will be abs(l1+l2 - 2* LCS)
    */
    int dp[][];
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        dp = new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]= 1+ dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return Math.abs((m+n) - (2*dp[m][n]));
    }
}
