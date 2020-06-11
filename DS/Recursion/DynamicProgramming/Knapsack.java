package data_structures.graph;

/**
 * Iterative and recursive apporach approach to solve knapsack problem. 
 * ks(w,i) = Max((value(i)+ks(W-w[i],i-1)),ks(W,i-1))
 */
public class Knapsack {
	
	
	
	
	public static int ksRec(int weight[],int item[],int W , int i) {
		if(i==-1||W==0)
			return 0;
		
		if(weight[i]<=W) {
			int include = item[i] + ksRec(weight, item, W - weight[i], i-1);
			int exclude = ksRec(weight, item, W , i-1);
			return Math.max(include, exclude);
		}
		else {
			return ksRec(weight, item, W , i-1);
		}
		
	}
	
	
	public static int ksMemoization(int weight[],int item[],int W , int i,int dp[][]) {
		if(i==-1||W==0)
			return 0;
		
		if(dp[W][i]!=-1)
			return dp[W][i];
		
		if(weight[i]<=W) {
			int include = item[i] + ksMemoization(weight, item, W - weight[i], i-1,dp);
			int exclude = ksMemoization(weight, item, W , i-1,dp);
			dp[W][i] = Math.max(include, exclude);
			return dp[W][i];
		}
		else {
			return dp[W][i] = ksMemoization(weight, item, W , i-1,dp);
		}
		
	}
	public static int knapSackMem(int weight[],int item[],int W ) {
		int n =weight.length;
		int dp[][] = new int[W+1][n];
		for(int i=0;i<=W;i++) {
			for(int j=0;j<n;j++)
				dp[i][j]= -1;
		}
		return ksMemoization(weight, item, W, n-1, dp);
	}

	public static int knapsack(int weight[], int item[], int W) {
		int n = item.length;
		int dp[][] = new int[W + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int w = 1; w <= W; w++) {
				if (weight[i - 1] <= w) {
					dp[w][i] = Math.max(dp[w - weight[i - 1]][i - 1] + item[i - 1], dp[w][i - 1]);
				} else {
					dp[w][i] = dp[w][i - 1];
				}
			}
		}

		return dp[W][n];
	}

	public static void main(String[] args) {
		int w[] = { 3, 7, 10, 6 };
		int item[] = { 4, 14, 10, 5 };
		int W = 20;
		System.out.println("Using tabulation: "+ knapsack(w, item, W));
		System.out.println("Using memoization: "+knapSackMem(w, item, W));
	}

}
