class Solution {
    public int[] sortArrayByParity(int[] A) {
        int n = A.length;
        int ans [] = new int[n];
        int j= 0;
        for(int i=0; i<n ; i++){
            if(A[i]%2==0)
                ans[j++] = A[i];
        }
        for(int i=0 ; i<n ; i++){
            if(A[i]%2 != 0)
                ans[j++] = A[i];
        }
        return ans;
    }
}
