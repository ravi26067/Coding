/*
* This code just follow fabinnaci series
**/
class Solution {
    long arr[] = new long[46];
    public int climbStairs(int n) {
        for(int i=1;i<=n;i++){
                if(i==1|| i==2){
                    arr[i] = (long)i;
                }
                else{
                    arr[i] = arr[i-1]+ arr[i-2];
                }
        }
        return (int)arr[n];
    }
}
