class Solution {
    public int bitwiseComplement(int N) {
        if(N==0)
            return 1;
        int x = N;
        int ans = 0;
        int pow = 1;
        while(x>0){
          //System.out.println(x+" : "+ (x&1));
        int k = (x&1)==1?0:1;
        ans += k*pow;
            pow*=2;
          x=x>>1;
      }
        return ans;
    }
}
