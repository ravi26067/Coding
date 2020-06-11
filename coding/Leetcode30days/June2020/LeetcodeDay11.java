class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int white =0;
        int blue =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                red++;
            else if(nums[i]==1)
                white++;
            else
                blue++;
        }
        int i=0;
        while(red>0 || white>0 || blue>0){
            if(red>0)
            {
                nums[i++] = 0;
                red--;
            }
            else if(white>0){
                nums[i++] = 1;
                white--;
            }
            else{
                nums[i++] = 2;
                blue--;
            }
        }
    }
}