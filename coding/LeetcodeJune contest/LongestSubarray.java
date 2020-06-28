class Solution {
    public int longestSubarray(int[] nums) {
		
		int prev= 0;
		int tmp = 0;
		int max = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==0) {
				if(max < tmp + prev)
					max = tmp + prev;
				prev = tmp;
				tmp = 0;
			}else if(nums[i]==1) {
				tmp++;
			}
		}
		if(max < tmp + prev)
			max = tmp + prev;
		
		if(tmp == nums.length)
			max = tmp-1;
		
		return max;
	}
}