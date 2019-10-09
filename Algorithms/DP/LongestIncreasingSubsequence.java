package com.dynamicprogramming;

public class LongestIncreasingSubsequence {

	
	public static void main(String[] args) {
		int arr[] = {10,22,9,33,21,50,41,60};
		LIS lis = new LIS(arr.length);
		System.out.println("Longest increasing subsequence length: "+lis.getLis(arr,arr.length));;
	}

}


class LIS{
	
	int [] LISarr = null;
	int max = 0;
	
	public LIS(int n) {
		LISarr = new int[n];
		for(int i = 0 ;i<n ;i++)
			LISarr[i] = 1;
	}
	
	int getLis(int arr[],int n){
		
		for(int i = 1 ;i < n;i++)
		{
			for(int j=0 ; j<i; j++) {
				if(arr[j]<arr[i] && LISarr[j] + 1 > LISarr[i])
				{
					LISarr[i] = LISarr[j] + 1;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			if(max< LISarr[i])
				max= LISarr[i];
		}
		
		return max;
	}
}