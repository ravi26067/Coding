class Solution {
    public int lengthOfLastWord(String s) {

        if(s==null)
            return 0;
        
        int i = s.length()-1;
        
        int cnt = 0;
        while(i>-1){
            
            if(s.charAt(i)== ' ' && cnt > 0)
                break;
            if(s.charAt(i) != ' ')
                cnt++;
            
            i--;
        }
        
        return cnt;
        // String[] arr = s.split("\\s+");
        // int len = arr.length;
        // //System.out.println(len);
        // if(len==0)
        //     return 0;
        // return arr[len-1].length();
    }
}