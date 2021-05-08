class Solution {
    
    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        int cnt = 0;
        Map<String,Integer> mp = new HashMap();

        for(String s1:words){
            if(mp.containsKey(s1)){
                mp.put(s1,mp.get(s1)+1);
            }else
                mp.put(s1,1);
        }

        for(String a: mp.keySet()){
            int m = a.length();
            int i=0,j=0;
            while(i<m&&j<n){
                if(a.charAt(i)==s.charAt(j)){
                    i++;
                    j++;
                }else
                    j++;
            }
            if(i==m)
                cnt+=mp.get(a);
        }

        /**
        * This is basic two pointer approach to check if a is subsequence of b or not. But here in input array we can have 
        * multiple similar inputs, so we have maintained HashMap in the above approach to track duplicate inputs count.
        
        for(String a:words){
            int m = a.length();
            int i=0,j=0;
            while(i<m&&j<n){
                if(a.charAt(i)==s.charAt(j)){
                    i++;
                    j++;
                }else
                    j++;
            }
            if(i==m)
                cnt++;
        }*/
        return cnt;
    }
}
