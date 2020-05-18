class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int []char_count= new int[26];
        
        for(char c:s1.toCharArray())
            char_count[c-'a']++;
        
        
        int left =0;
        int right=0;
        int count = s1.length();
        
        while(right<s2.length()){
            
            if(char_count[s2.charAt(right++)-'a']-- >= 1)
                count--;
            
            if(count==0)
                return true;
            
            if(right-left == s1.length() && char_count[s2.charAt(left++)-'a']++ >=0)
                count++;
            
            
        }
        
        return false;
        
        
    }
}