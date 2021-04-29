package dynamic.programming.knapsack;

/**
 * Here this is just like subset of equal sum, just the variation is that we are using '+' because we need the count so
 * we will be considering every possibility.
 */

public class CountSubsetSum {

    int dp[][];

    public int countOfSubsetSum(int arr[], int sum, int n){

        dp= new int [n+1][sum+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0)
                    dp[i][j]=0;
                if(j==0)
                    dp[i][j]=1;
                if(i>0 && j>0){
                    if(arr[i-1]>j)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,3};
        CountSubsetSum countSubsetSum = new CountSubsetSum();
        int sum = 6;
        System.out.println("Count of subsets: " + countSubsetSum.countOfSubsetSum(arr,sum,arr.length));
    }

}
