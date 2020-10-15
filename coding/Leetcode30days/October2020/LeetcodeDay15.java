class Solution {
    
    private void swapArr(int[] nums, int strt,int end){
        
        while(strt<end){
            int tmp = nums[strt];
            nums[strt] = nums[end];
            nums[end] = tmp;
            strt++;
            end--;
        }
        
    }
    
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        swapArr(nums,0,n-k-1);
        swapArr(nums,n-k,n-1);
        swapArr(nums,0,n-1);
    }
}
