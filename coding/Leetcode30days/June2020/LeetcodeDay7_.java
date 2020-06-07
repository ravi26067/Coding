import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

	public int change(int amount, int[] coins) {
		
		int dp[][] = new int[coins.length+1][amount+1];
		
		for(int i=0;i<=coins.length;i++) {
			for(int j=0;j<=amount;j++) {
				if(j==0)
					dp[i][j] = 1;
				else if(i==0)
					dp[i][j] = 0;
				else {
					dp[i][j] = dp[i-1][j] + (j-coins[i-1]<0 ? 0: dp[i][j-coins[i-1]]);
				}
			}
		}
		
		return dp[coins.length][amount];
	}

	public static void main(String[] args) {
		Solution sl = new Solution();
		int amount = 5;
		int coins[] = {1,2,5};
		System.out.println(sl.change(amount, coins));
	}

}