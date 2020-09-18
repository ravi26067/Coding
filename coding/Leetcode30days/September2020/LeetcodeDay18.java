class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(int i= prices.length-1;i>=0;i--){
            if(prices[i] < max){
                ans = (max-prices[i] > ans) ? max-prices[i]: ans;
            }else{
                max = prices[i];
            }
        }
        return ans;
    }
}
