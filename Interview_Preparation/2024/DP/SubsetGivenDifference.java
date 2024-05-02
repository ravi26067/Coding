//https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
class Solution {
    public static int countPartitions(int n, int d, int[] arr) {
        int sum = 0;
        for (int i=0;i<n;i++){
            sum+=arr[i];
        }
        
        //s1 - s2 = diff
        //s1+s2 = sum
        //2s1 = diff + sum => s1 = (diff+sum)/2
        
        int mod = 1000000007;
        
        if ((d+sum)%2!=0){
            return 0;
        }
        
        int s1 = ((d+sum)/2)% mod;
        
        int dp[][] = new int[n+1][s1+1];
        
        dp[0][0] = 1;
        for(int i=1;i<n+1;i++){
            for(int j=0;j<(s1+1);j++){
                if(arr[i-1]<=j){
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-arr[i-1]])%mod;
                }else{
                     dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][s1]%mod;
    }
}

/*
TWO REASONS FOR NOT GETTING ACCEPTED:
1)  We are initialising first column to 1, assuming there is only 1 way to make subset sum equal to 0, 
i.e. null subset, BUT this fails if we have 0's as elements of array. If we have a single 0 present in
the array, then the subsets will be '{}, {0}' whose sum will be 0. Hence, there can be more than 1 way to make sum==0.
FIX: Don't initialise the first col to be 1. Everything will be initialized to 0 except the first cell in the table i.e.
dp[0][0]=1. AND j will start from 0 instead of 1.
2) We also need to take care of the edge case where it's not possible to partition the array. 
In the derived formula, target = (diff+totalSum) / 2, NOTICE that (diff+totalSum) must be even for target to be a whole number,
else it's not possible to find a decimal target in subset sum.
FIX: Check, if it's odd,  there is no way --> if((diff+totalSum)%2 != 0) return 0;


For Input: 
10
12
0 1 2 2 2 3 0 3 0 1
Your Code's output is: 
8
It's Correct output is: 
16
Output Difference
816
*/
