package dynamic.programming;

/**
 * This is exactly like knapsack problem. First find the recursive approach.
 * Then try to solve via memorization, after that tabulation is very easy.
 */
public class SubsetSum {


    static Boolean dp [][] ;

    SubsetSum(int n,int sum){
        dp= new Boolean[n+1][sum+1];
        /*for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                dp[i][j]= null;
            }
        }*/
    }

  //recurssive 
    static boolean isSubsetSum(int set[], int n, int sum)
    {
        if (sum==0)
            return true;
        if(n==0)
            return false;

        if(set[n-1]>sum)
            return isSubsetSum(set,n-1,sum);

        return isSubsetSum(set,n-1,sum-set[n-1]) || isSubsetSum(set,n-1,sum);
    }

  //memorization
    static boolean isSubsetSumMem(int set[],
                               int n, int sum)
    {

        //System.out.println("n: " + n + " sum: " + sum);

        if (sum==0) {
            dp[n][sum] = true;
            return dp[n][sum];
        }
        if(n==0) {
            dp[n][sum] = false;
            return dp[n][sum];
        }

        if(dp[n][sum]==null){
            dp[n][sum] = isSubsetSumMem(set, n - 1, sum);
        }

        if (set[n - 1] > sum) {
            return dp[n][sum];
        }


        if(dp[n][sum-set[n-1]]==null)
            dp[n][sum-set[n-1]] = isSubsetSumMem(set,n-1,sum-set[n-1]);
        return dp[n][sum-set[n-1]] || dp[n][sum];
    }

  //tabulation
    static boolean isSubSetTab(int set[], int n, int sum){

        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0)
                    dp[i][j]=false;

                if (j==0)
                    dp[i][j] = true;
                if(i>0){
                    if(set[i-1]>j)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-set[i-1]];
                }

            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 35;
        SubsetSum subsetSum = new SubsetSum(set.length,sum);
        if(isSubsetSumMem(set,set.length,sum))
            System.out.println("Sum possible!!");
        else
            System.out.println("Sum not possible!!");
    }
}
