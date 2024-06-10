class Solution {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int n = prices.length;
        int ans = 0;
        for(int i=n-1;i>=0;i--){
            if(max>prices[i]){
                ans = Math.max(ans,max-prices[i]);
            }else{
                max = prices[i];
            }
            //System.out.println("ans: "+ ans +" ,max : " + max + " ,i: " +i);
        }
        return ans;
    }
}
