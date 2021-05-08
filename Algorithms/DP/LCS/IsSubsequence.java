class Solution{
    int dp[][];
    boolean isSubSequence(String A, String B){
        int m = A.length();
        int n = B.length();
        
        dp = new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(A.charAt(i-1)==B.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return (dp[m][n]==m)? true:false;
    }
    
    /**
    * This is two pointer approach which is better than DP
    boolean isSubSequence(String A, String B){
        int m = A.length();
        int n = B.length();
        int i=0,j=0;
        while(i<m&&j<n){
            if(A.charAt(i)==B.charAt(j)){
                i++;
                j++;
            }else
                j++;
        }
        if(i<m)
            return false;
        else
            return true;
    }
    */
}
