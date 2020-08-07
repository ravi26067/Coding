class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList();
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1] > 0)
                nums[Math.abs(nums[i])-1] *= -1;
            else{
                res.add(Math.abs(nums[i]));
            }
        }
        
        return res;
    }
}