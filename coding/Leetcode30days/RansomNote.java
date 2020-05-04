class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //int [] ransom = new int[26];
        int [] mag = new int[26];
        
        for(int i=0;i<magazine.length();i++){
            mag[magazine.charAt(i)-97]++;
        }
        
        for(int i=0;i<ransomNote.length();i++){
            if(mag[ransomNote.charAt(i)-97]<1)
                return false;
            else
                mag[ransomNote.charAt(i)-97]--;
        }
        return true;
    }
}