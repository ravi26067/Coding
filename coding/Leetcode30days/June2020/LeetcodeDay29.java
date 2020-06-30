class Solution {
    long dfs[][] = new long[100][100];
	boolean fl = false;
	
	public int uniquePaths(int m, int n) {
		
		if(fl==false) {
			for(int i=0;i<100;i++) {
				dfs[0][i] = 1;
				dfs[i][0] = 1;
			}
			
			for(int i=1;i<100;i++) {
				for(int j=1;j<100;j++) {
					dfs[i][j] = dfs[i-1][j] + dfs[i][j-1];
				}
			}
			fl = true;
		}
		
		return (int)dfs[m-1][n-1];
	}
}