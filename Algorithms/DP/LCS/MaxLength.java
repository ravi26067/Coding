/**
* This is variaton of the longest common subsequence, just the difference is that here we have 
* continuous string or element which was not in earlier case. So if string doesnt match we will 
* make dp[i][j] = 0.
*/
class Solution {
    int dp[][];
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        dp = new int[n+1][m+1];
        int max = 0;
        for(int i=0;i<=n ;i++){
            for(int j=0;j<=m ;j++){
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = 1+ dp[i-1][j-1];
                    if(dp[i][j]>max)
                        max=dp[i][j];
                }
                else
                    dp[i][j]=0;
            }
        }
        return max;
    }
}
