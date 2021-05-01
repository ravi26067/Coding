package dynamic.programming.knapsack;

import java.util.Arrays;


/**
 * Here is just small variation,
 * s1-s2 = diff
 * s1+s2 = sum
 * s1 = (diff + sum)/2
 * Now apply count subset sum
 */
public class CountSubsetDiff {

    int dp[][];

    public int countSubsetWithGivenDiff(int nums[],int diff){
        int n = nums.length;
        int sum1 = Arrays.stream(nums).sum();
        System.out.println("sum: " + sum1);

        int s1 = (sum1 + diff)/2;

        dp = new int[n+1][s1+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=s1;j++){
                if(i==0)
                    dp[i][j]=0;
                if(j==0)
                    dp[i][j]=1;
                if(i>0&&j>0){
                    if(nums[i-1] > j)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][s1];
    }

    public static void main(String[] args) {
        int arr[] = {1,1,2,3};
        int diff = 1;
        CountSubsetDiff subsetDiff = new CountSubsetDiff();
        System.out.println("Count is: " + subsetDiff.countSubsetWithGivenDiff(arr,diff));
    }
}
