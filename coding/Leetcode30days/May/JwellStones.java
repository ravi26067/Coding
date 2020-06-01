class Solution {
    public int numJewelsInStones(String J, String S) {
        int []jewels = new int[256];
        int ans = 0;
        for(int i=0;i<J.length();i++){
           jewels[J.charAt(i)]++; 
        }
        
        for(int i=0;i<S.length();i++){
            if(jewels[S.charAt(i)]>0)
                ans++;
        }
        return ans;
    }
}