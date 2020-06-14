import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;




/**
 * https://www.youtube.com/watch?v=Wv6DlL0Sawg
 */
class Solution {
	
	public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList();
        int n = nums.length;
        if(n==0)
        	return ans;
        
        Arrays.sort(nums);
        
        int max =1;
        
        int dp[] = new int[n];
        
        Arrays.fill(dp, 1);
        
        for(int i=1;i<n;i++) {
        	for(int j=0;j<i;j++) {
        		if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]) {
        			dp[i] = 1+dp[j];
        			if(max<dp[i])
        				max = dp[i];
        		}
        	}
        }
        
        int prev = -1;
        for(int i=n-1;i>=0;i--) {
        	if(dp[i]==max && (prev%nums[i]==0 || prev == -1)) {
        		ans.add(nums[i]);
        		max -=1;
        		prev = nums[i];
        	}
        }
        
        Collections.reverse(ans);
        
        return ans;
    }

	public static void main(String[] args) {
		Solution sl = new Solution();
		int arr[] = { 4, 3, 1, 1, 3, 3, 2 };
		int k = 3;
		List<Integer> ans = sl.largestDivisibleSubset(arr);
	}
}