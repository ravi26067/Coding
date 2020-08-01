class Solution {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        if(len==1)
            return true;
        else{
            if(word.charAt(0) >=97 && word.charAt(0)<123 && word.charAt(1) >=65 && word.charAt(1)<91)
                return false;
        }
        for(int i=1;i<len;i++){
            if(i!=1 && word.charAt(i-1) >=97 && word.charAt(i-1)<123 && word.charAt(i) >=65 && word.charAt(i)<92
              ||i!=1 && word.charAt(i) >=97 && word.charAt(i)<123 && word.charAt(i-1) >=65 && word.charAt(i-1)<92)             {
                return false;
            }
        }
        return true;
    }
}