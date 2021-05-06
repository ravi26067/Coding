class Solution {
    /**
    * Here we have just used LCS approach for finding longest palindrome size in a string. 
    * Then once we get that , its easy for us as the number of insertion will be same.
    * Also this code will be applicable for minimum of deletions.
    */
    int dp[][];
    public int minInsertions(String s) {
        int m = s.length();
        dp = new int [m+1][m+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(s.charAt(i-1)==s.charAt(m-j))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
            
        }
        //return Math.abs(m-dp[m][m]);
        return (m-dp[m][m]);
    }
}
