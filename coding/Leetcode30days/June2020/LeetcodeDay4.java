class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        int left =0;
        int right = len-1;
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}