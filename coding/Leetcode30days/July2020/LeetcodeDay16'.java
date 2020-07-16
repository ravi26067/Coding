class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1.0;
        else if(n == 1)
            return x;
        else if(n == -1)
            return 1.0/x;
        else{
            double y = (n > 0) ? x : 1.0/x;
            long m = (n > 0) ? (long)n : -((long)n);
            double result = 1.0;
            while(m > 0){
                if((m & 1) == 0){
                    y = y*y;
                    m = m >> 1;
                }else{
                    result = result * y;
                    --m;
                }
            }
            
            return result;
        }
    }
}