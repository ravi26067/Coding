class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        for(int i=0;i<s.length();i++){
            map[s.charAt(i)]++;
        }
        int totalLen = 0;
        int single = 0;
        for(int i=0;i<map.length;i++){
            if(map[i]%2 == 0)
                totalLen += map[i];
            else{
                totalLen += map[i]-1;
                single = 1;
            }
        }
        return totalLen + single;
    }
}
