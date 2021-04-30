package dynamic.programming.knapsack;

import java.util.ArrayList;

/**
 * Here its similar to equal sum partition , there s2-s1=0 and here it should be minimum.
 * We will be calculating the dp table to check if given sum is possible for S1 or not.
 * We will consider s1(sum of subset 1) to lie in first half of range. So we will iterate till range(sum)/2.
 */

public class SubetSumDiff {

    boolean dp [][];

    /*public int minimumSubsetSumDiff(int arr[],int sum){
        int n = arr.length;
        dp = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0)
                    dp[i][j] = false;
                if(j==0)
                    dp[i][j] = true;
                if(i>0&&j>0){
                    if(arr[i-1]>j)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
            }
        }

        Integer mn = Integer.MAX_VALUE;

        for(int i=1;i<sum/2;i++){
            if(dp[n][i]){
                mn = Math.min(mn,sum - (2 * i));
            }
        }

        return mn;
    }*/

    public int minimumSubsetSumDiff(ArrayList<Integer> A) {
        int n = A.size();
        int arr[] = new int[n];
        int sum = 0;
        // to handle corner cases
        if(n==1)
            return A.get(0);
        for(int i=0;i<n;i++){
            arr[i] = A.get(i);
            sum+=arr[i];
        }
        dp = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0)
                    dp[i][j] = false;
                if(j==0)
                    dp[i][j] = true;
                if(i>0&&j>0){
                    if(arr[i-1]>j)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
            }
        }

        Integer mn = Integer.MAX_VALUE;

        for(int i=1;i<sum/2+1;i++){
            if(dp[n][i]){
                mn = Math.min(mn,sum - (2 * i));
            }
        }

        return mn;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(5);
        array.add(2);
        SubetSumDiff sumDiff = new SubetSumDiff();
        System.out.println("Minimum sum difference: " + sumDiff.minimumSubsetSumDiff(array));
    }

}
