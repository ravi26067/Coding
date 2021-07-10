## Round 1: Problem Solving

**Problem** :- https://leetcode.com/problems/daily-temperatures/

Solution :- 

``` java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        Stack<Integer> st = new Stack();
        int answer[] = new int[n];
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i])
                st.pop();
            
            if(!st.isEmpty() && temperatures[st.peek()] > temperatures[i]){
                answer[i] = (st.peek()-i);
            }else
                answer[i] = 0;
            
            st.push(i);
        }
        
        return answer;
    }
}

```

**Problem** :- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

Solution:

``` java
class Solution {
    public int maxProfit(int[] prices, int fee) {
        //10-5-2,7-1-2 = 4
        
        int len = prices.length,buying = 0, selling = -prices[0];
        for(int i=1;i<len;i++){
            buying = Math.max(buying,selling + prices[i] - fee);
            selling = Math.max(selling, buying - prices[i]);
        }
        return buying;
    }
}

```

