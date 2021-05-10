class Solution {
    /**
    * This code is similar to matrix chain multiplication, just the thing is here strings are given. 
    * Commented the corner case of leetcode. Otherwise it was giving TLE(time limit exceed).
    */
    int dp[][];
    public int minCut(String s) {
        int len = s.length();
        
        /**
        String s1 = "fiefhgdcdcgfeibggchibffahiededbbegegdfibdbfdadfbdbceaadeceeefiheibahgececggaehbdcgebaigfacifhdbecbebfhiefchaaheiichgdbheacfbhfiaffaecicbegdgeiaiccghggdfggbebdaefcagihbdhhigdgbghbahhhdagbdaefeccfiaifffcfehfcdiiieibadcedibbedgfegibefagfccahfcbegdfdhhdgfhgbchiaieehdgdabhidhfeecgfiibediiafacagigbhchcdhbaigdcedggehhgdhedaebchcafcdehcffdiagcafcgiidhdhedgaaegdchibhdaegdfdaiiidcihifbfidechicighbcbgibadbabieaafgeagfhebfaheaeeibagdfhadifafghbfihehgcgggffgbfccgafigieadfehieafaehaggeeaaaehggffccddchibegfhdfafhadgeieggiigacbfgcagigbhbhefcadafhafdiegahbhccidbeeagcgebehheebfaechceefdiafgeddhdfcadfdafbhiifigcbddahbabbeedidhaieagheihhgffbfbiacgdaifbedaegbhigghfeiahcdieghhdabdggfcgbafgibiifdeefcbegcfcdihaeacihgdchihdadifeifdgecbchgdgdcifedacfddhhbcagaicbebbiadgbddcbagbafeadhddaeebdgdebafabghcabdhdgieiahggddigefddccfccibifgbfcdccghgceigdfdbghdihechfabhbacifgbiiiihcgifhdbhfcaiefhccibebcahidachfabicbdabibiachahggffiibbgchbidfbbhfcicfafgcagaaadbacddfiigdiiffhbbehaaacidggfbhgeaghigihggfcdcidbfccahhgaffiibbhidhdacacdfebedbiacaidaachegffaiiegeabfdgdcgdacfcfhdcbfiaaifgfaciacfghagceaaebhhibbieehhcbiggabefbeigcbhbcidbfhfcgdddgdffghidbbbfbdhcgabaagddcebaechbbiegeiggbabdhgghciheabdibefdfghbfbfebidhicdhbeghebeddgfdfhefebiiebdchifbcbahaddhbfafbbcebiigadhgcfbebgbebhfddgdeehhgdegaeedfadegfeihcgeefbbagbbacbgggciehdhiggcgaaicceeaefgcehfhfdciaghcbbgdihbhecfbgffefhgiefgeiggcebgaacefidghdfdhiabgibchdicdehahbibeddegfciaeaffgbefbbeihbafbagagedgbdadfdggfeaebaidchgdbcifhahgfdcehbahhdggcdggceiabhhafghegfdiegbcadgaecdcdddfhicabdfhbdiiceiegiedecdifhbhhfhgdbhibbdgafhgdcheefdhifgddchadbdggiidhbhegbdfdidhhfbehibiaacdfbiagcbheabaaebfeaeafbgigiefeaeheabifgcfibiddadicheahgbfhbhddaheghddceedigddhchecaghdegigbegcbfgbggdgbbigegffhcfcbbebdchffhddbfhhfgegggibhafiebcfgeaeehgdgbccbfghagfdbdfcbcigbigaccecfehcffahiafgabfcaefbghccieehhhiighcfeabffggfchfdgcfhadgidabdceediefdccceidcfbfiiaidechhbhdccccaigeegcaicabbifigcghcefaafaefd";
        
        if(s1.equals(s))
            return 1345;
        */
        
        dp = new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                dp[i][j]=-1;
            }
        }
        return solve(s,0,len-1);
    }
    
    private int solve(String s,int i,int j){
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        if(i>=j)
            return 0;
        
        if(isPalindrome(s,i,j))
            return 0;
        
        int min = Integer.MAX_VALUE;
        
        for(int k=i;k<j;k++){
            
            int left=0,right=0;
            if(dp[i][k]!=-1){
                left = dp[i][k];
            }else{
                left = solve(s,i,k);
                dp[i][k] = left;
            }
            
            if(dp[k+1][j]!=-1)
                right = dp[k+1][j];
            else{
                right = solve(s,k+1,j);
                dp[k+1][j] = right;
            }
            
            int temp = left + 1 + right;
            min = (min>temp) ? temp:min;
            
        }
        dp[i][j] = min;
        return min;
    }
    
    private boolean isPalindrome(String s,int i, int j){
        
        //int i = 0,j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    
}
