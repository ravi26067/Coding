package com.arrays;

import java.util.Scanner;

public class LongestSpan {
	
	static int max(int a,int b) {
		return a>b?a:b;
	}

	/*static int longestSpaninBinaryArray(int arr1[],int arr2[],int n) {
		int res = 0;
		int sum1 ,sum2;
		
		for(int i=0;i<n;i++) {
			sum1 = 0;
			sum2 = 0;
			for(int j =i ;j<n;j++) {
				sum1 += arr1[j];
				sum2 += arr2[j];
				
				if(sum1==sum2)
				{
					res = max(res , j-i+1);
				}
			}
		}
		
		return res;
	}*/
	
	static int longestSpainArray(int arr1[],int arr2[],int n) {
		int maxsum = 0 ,curr_diff=0;
		int diffarr[] = new int[2*n+1];
		for(int i = 0; i<2*n+1 ;i++)
			diffarr[i] = -1;
		
		for(int i = 0 ; i<n ;i++) {
			curr_diff += arr1[i] - arr2[i];
			
			int diff_ind = n + curr_diff ;
			
			if(curr_diff == 0)
				maxsum += i+1;
			else if(diffarr[diff_ind] == -1) 
				diffarr[diff_ind] = i;
			else {
				int len = i - diffarr[diff_ind];
				if(len>maxsum)
					maxsum = len;
			}
		}
		
		return maxsum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0) {
			int n = sc.nextInt();
			int arr1[] = new int [n];
			int arr2[] = new int [n];
			for(int i = 0 ;i < n ;i++)
				arr1[i] = sc.nextInt();
			for(int i = 0 ;i < n ;i++)
				arr2[i] = sc.nextInt();
			int res  = longestSpainArray(arr1, arr2, n);
			System.out.println(res);
			t--;
		}
	}

}
