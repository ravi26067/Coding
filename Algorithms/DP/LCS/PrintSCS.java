class Solution {
  /**
  * Similar as LCS, just here we are not only printing LCS but also considering the remaining ones.
  */
    int dp[][];
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j] = 1+ dp[i-1][j-1];
                else 
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        int i=m;
        int j=n;
        //Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                //st.push(str1.charAt(i-1));
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i][j-1] > dp[i-1][j]){
                    //st.push(str1.push(i-1));
                    sb.append(str2.charAt(j-1));
                    j--;
                }else{
                    //st.push(str2.push(j-1));
                    sb.append(str1.charAt(i-1));
                    i--;
                    
                }
            }
        }
        while(i>0){
            //st.push(str1.charAt(i-1));
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            //st.push(str2.charAt(j-1));
            sb.append(str2.charAt(j-1));
            j--;
        }
       return String.valueOf(sb.reverse());
    }
}
