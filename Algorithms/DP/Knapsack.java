package dynamic.programming;

/**
 * We have W as total weight and N size of array which contains values. We will have 2D matrix of size N+1 , W+1.
 * We will divide problem into sub problem and compute for those.
 */
public class Knapsack {

    int dp[][];

    Knapsack(int n,int w){
        dp = new int[n+1][w+1];
    }

    int maximumValue(int wg[], int val[], int W) {
        int n = val.length;
        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0||j==0)
                    dp[i][j] = 0;
                else if(wg[i-1]<=j){
                    System.out.println("W[i-1]: " + wg[i-1] + " j: " + j);
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wg[i-1]],dp[i-1][j]);
                    System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                    System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
                }
            }
        }
        return dp[n][W];
    }

    /*public static void main(String[] args) {
        int wg[] = {1,2,3};
        int val[] = {60,100,120};
        int W = 5;
        Knapsack knapsack= new Knapsack(val.length,W);
        System.out.println("Maximum profit: "+ knapsack.maximumValue(wg,val,W));
    }*/
}
