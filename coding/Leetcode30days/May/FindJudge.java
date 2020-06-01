class Solution {
    public int findJudge(int N, int[][] trust) {
		int n = trust.length;
		int max = 0;
		int mxind = 0;
        int cnt =0;
		int arr[] = new int[N+1];

        if(N==1)
			return 1;
        else if(N==0)
            return -1;
        
		for (int i = 0; i < n; i++) {
			arr[trust[i][1]]++;
			if (arr[trust[i][1]] > max) {
				max = arr[trust[i][1]];
				mxind = trust[i][1];
			}
		}

		for (int i = 0; i < n; i++) {
			if (arr[trust[i][0]] == max) {
				return -1;
			}
		}
        
        for(int i=0;i<N;i++) {
			if(arr[i]==max)
				cnt++;
		}
		if(cnt>1)
			return -1;

		return mxind;
	}
}