class Solution{

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        boolean t[][] = new boolean[N+1][sum+1];
        
        for (int i=0;i<N+1;i++){
            for(int j=0;j<sum+1;j++){
                if (j==0)
                    t[i][j]=true;
                else if(i==0)
                    t[i][j]=false;
                else if (arr[i-1]<=j){
                    t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[N][sum];
    }
    
}
