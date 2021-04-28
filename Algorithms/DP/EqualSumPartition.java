/**
* Here we use similar approach to subset sum, just the thing is we have first calculated the sum and if sum is odd then we will return false.
* Otherwise we will call subsetsum method by passing sum/2 as param to it.
*/
class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++)
            sum+=nums[i];
        if(sum%2!=0)
            return false;
        else{
            sum = (sum!=0)?sum/2:0;
            dp = new Boolean[n+1][sum + 1];
            return subsetSum(nums,n,sum);
        }
    }
    
    private boolean subsetSum(int [] nums,int n,int sum){
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0)
                    dp[i][j]=false;
                if(j==0)
                    dp[i][j]=true;
                if(i>0 && j>0){
                    if(nums[i-1] > j)
                        dp[i][j] = dp[i-1][j];
                    else{
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                    }
                }
            }
        }
        return dp[n][sum];
    }
    
}
