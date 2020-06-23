class Solution {
    public int singleNumber(int[] nums) {
        int res =0;
        int bits[] = new int[32];
        for(int i=0;i<32;i++){
            for(int num:nums){
                bits[i] += num>>i & 1;
                bits[i] = bits[i]%3;
            }
        }
        
        for(int i=0;i<32;i++){
            res |= bits[i]<<i;
        }
        return res;
    }
}