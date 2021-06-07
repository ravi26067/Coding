class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        Map<Integer,Integer> mp = new HashMap();
        int res = Integer.MIN_VALUE;
        for(int num:nums){
            
            if(!mp.containsKey(num)){
                int left = (mp.containsKey(num-1))?mp.get(num-1):0;
                int right = (mp.containsKey(num+1))?mp.get(num+1):0;
                int sum = left + 1 + right ;
                res = Math.max(res,sum);
                mp.put(num,sum);
                
                mp.put(num-left,sum);
                mp.put(num+right,sum);
            }
            
        }
        return res;
    }
}
