/**
 * Wr are just cheking if number is less than 9 return the list 
 * else we are creating tmp with n+1 size and setting first bit 
 * as zero to handle special case with all 9's.
 */
class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
        
        for(int i=n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int tmp[] = new int[n+1];
        tmp[0] = 1;
        return tmp;
    }
}