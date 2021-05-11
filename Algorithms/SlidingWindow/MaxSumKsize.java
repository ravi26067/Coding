class Solution{
  /**
  * Use one loop till i to k , then deduct k-1 from sum and add ith element till N.
  */
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        int cSum = 0;
        int mSum = 0;
        for(int i=0;i<K;i++){
            cSum += Arr.get(i);
        }
        mSum = cSum;
        
        int i = K;
        while(i<N){
            cSum =  (cSum - Arr.get(i-K)) + Arr.get(i);
            if(mSum<cSum)
                mSum=cSum;
            //System.out.println(cSum);
            i++;
        }
        return mSum;
    }
}
