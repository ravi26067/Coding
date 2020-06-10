package data_structures.graph;

/**
 * Iterative approach to solve knapsack problem. 
 * ks(w,i) = Max((value(i)+ks(W-w[i],i-1)),ks(W,i-1))
 */
public class Knapsack {

	public static int knapsack(int weight[], int item[], int W) {
		int n = item.length;
		int dp[][] = new int[W + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int w = 1; w <= W; w++) {
				if (weight[i - 1] <= w) {
					dp[w][i] = Math.max(dp[w - weight[i - 1]][i - 1] + item[i - 1], dp[w][i - 1]);
					System.out.println("dp [j][i] " + dp[w][i]);
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
		System.out.println(knapsack(w, item, W));
	}

}
