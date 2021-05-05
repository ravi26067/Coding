class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    static int dp[][];
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Find the LCS of two strings.
        //LCS is the common sequence so the shortest common sequence will be l1+l2-LCS
        dp = new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(X.charAt(i-1) == Y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return (m+n-dp[m][n]);
        
    }
}
