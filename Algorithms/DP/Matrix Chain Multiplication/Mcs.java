class Solution{
  
    /**
    * Here we will have i as 1 and j as n-1. Out k will lie from i to j. We will have partition and call recursively.
    * Ai = arr[i-1][i] => A1 = arr[0][1] 
    * We will solve A1 * (A2*A3*A4) || (A1*A2)*(A3*A4)
    */
    
    static int dp[][] ;
    
    static int matrixMultiplication(int N, int arr[])
    {
        dp = new int [501][501];
        for(int i=0;i<501;i++){
            for(int j=0;j<501;j++){
                dp[i][j] = -1;
            }
        }
        return solve(arr,1,N-1);
    }
    
    static int solve(int arr[],int i,int j){
        
        if(i>=j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
            
        int res = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int tmp = solve(arr,i,k) + solve(arr,k+1,j) + (arr[i-1]*arr[k]*arr[j]);
            res = (res>tmp)?tmp:res;
        }
        dp[i][j] = res;
        return res;
        
    }
    
}
