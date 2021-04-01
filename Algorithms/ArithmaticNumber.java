class Solution{
    static int inSequence(int A, int B, int C){
        // code here
        if(C==0){
            if(A==B)
            return 1;
            else 
            return 0;
        }
        
        if((B-A)/C < 0)
            return 0;
        return ((B-A)%C == 0)?1:0;
    }
}
