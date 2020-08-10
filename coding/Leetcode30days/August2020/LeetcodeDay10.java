class Solution {
    public int titleToNumber(String s) {
        int len = s.length()-1;
        int i = len;
        int letter = 0;
        long res = 0;
        while(i>=0){
            letter = s.charAt(len-i) - 64;
            //System.out.println(letter);
            res += (long) Math.pow(26,i)*(letter) ;
            //System.out.println(res);
            i--;
        }
        return (int)res;
    }
}
