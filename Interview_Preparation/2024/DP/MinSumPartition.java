//https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    int sum = 0;
	    for (int i=0;i<n;i++){
	        sum+=arr[i];
	    }
	    
	    boolean dp[][] = new boolean[n+1][sum+1];
	    
	    for(int i=0;i<n+1;i++){
	        for(int j=0;j<sum+1;j++){
	            if (j==0){
	                dp[i][j] = true;
	            }else if (i==0){
	                dp[i][j]= false;
	            }else if(arr[i-1]<=j){
	                dp[i][j] = (dp[i-1][j] || dp[i-1][j-arr[i-1]]);
	            }else{
	                dp[i][j] = dp[i-1][j];
	            }
	        }
	    }
	    int min = sum;
	    //System.out.println("Sum: " + sum);
	    
	    //iterate in
	    for (int i=0;i<(sum/2)+1;i++){
	        if(dp[n][i]){
	            //System.out.println("i: "+ i + " status: " + dp[n][i]);
	            min = Math.min(min,sum-(2*i));
	        }
	    }
	    return min;
	} 
	
}
