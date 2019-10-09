package com.dynamicprogramming;

import java.util.Scanner;

public class FabonacciNumber {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0) {
			int n = sc.nextInt();
			FabonaciTabl fabonaciTabl = new FabonaciTabl(n);
			System.out.println("Result using tabulation ->" + fabonaciTabl.fabonacci(n));;
			FabinacciMemo fabinacciMemo = new FabinacciMemo(n);
			System.out.println("Result using memorization ->" + fabinacciMemo.fibonacci(n));
			t--;
		}

	}

}

//Memorization
class FabinacciMemo{
	//calculating fabonacci using memorization technique
	int [] arr = null;
	
	public FabinacciMemo(int n) {
		arr = new int [n+1];
	}
	
	int fibonacci(int n) {
		if(arr[n] == 0) {
			if(n<=1)
				arr[n] = n;
			else
				arr[n] = fibonacci(n-1) + fibonacci(n-2);
		}
		return arr[n];
	}
}

//Tabulation
class FabonaciTabl{
	//tabulation where we initialise the base condition and iterate to compute the others
	int [] arr = null;
	
	public FabonaciTabl(int n) {
		arr = new int[n+1];
	}
	
	
	int fabonacci(int n) {
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 2 ;i <= n; i++)
			arr[i] = arr[i-1] + arr[i-2];
		return arr[n];
	}
	
}
