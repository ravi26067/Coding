class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int k)
    {
        int i = 0;
        
        //int fn = firstN(A,i,k);
        long res [] = new long[N-k+1];
        
        int fn = -1;
        
        while(i+k <= N){
            if(fn < i){
                fn = firstN(A,i,i+k);
                //System.out.println("i: " + i + " i+k: " + (i+k) + " fn: " + fn );
            }
            
            if(fn < 0)
                res[i] = 0;
            else
                res[i] = A[fn];
            i++;
        }
        return res;
    }
    
    private int firstN(long A[],int i,int k){
        
        for(int j=i;j<k;j++){
            if(A[j]<0)
                return j;
        }
        return -1;
    }
}
