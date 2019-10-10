package com.dynamicprogramming;

import java.util.Scanner;

public class LongestCommonSubsequence {
	
	public static int max(int a,int b) {
		return a>b?a:b;
	}

	public static int longestCommonSubseq(char[] str1,char[] str2,int a,int b) {
		int [][] lcs = new int [a+1][b+1];
		
		for(int i=0;i<a+1;i++)
		{
			for(int j=0;j<b+1;j++) {
				if(i==0 || j==0) {
					lcs[i][j] = 0;
				}else if(str1[i-1] == str2[j-1]) {
					lcs[i][j] = lcs[i-1][j-1] + 1;
				}else {
					lcs[i][j] = max(lcs[i-1][j] , lcs[i][j-1]);
				}
			}
		}
		
		return lcs[a][b];
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t , a ,b;
		t = sc.nextInt();
		while(t>0) {
			a = sc.nextInt();
			b = sc.nextInt();
			sc.nextLine();
			String str1 = sc.nextLine();
			String str2 = sc.nextLine();
			char s1[] = str1.toCharArray();
			char s2[] = str2.toCharArray();
			int lcs = longestCommonSubseq(s1,s2,a,b);
			System.out.println(lcs);
			t--;
		}
	}

}