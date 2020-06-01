import java.util.Scanner;
import java.util.Stack;

// 5 9 -6 9 -5 7 8
// 9 -5 7 8 5 9 -6

public class MaximumSum {

	/*
	 * void reverseArray(int arr[], int start, int end) { while (start < end) { int
	 * temp = arr[start]; arr[start] = arr[end]; arr[end] = temp; start++; end--; }
	 * }
	 */

	public int maxSubarraySumCircular(int[] A) {
		if(A==null||A.length==0) return 0;
        int maxTillHere = A[0];
        int maxintotal = A[0];
        int mintillhere = A[0];
        int minintotal = A[0];
        int sum = A[0];
        
        for(int i=1;i<A.length;i++) {
        	if(maxTillHere+ A[i] > A[i]) {
        		maxTillHere +=A[i];
        	}else {
        		maxTillHere = A[i];
        	}
        	
        	maxintotal = Math.max(maxintotal, maxTillHere);
        	
        	if(mintillhere + A[i] < A[i]) 
        		mintillhere +=A[i];
        	else
        		mintillhere = A[i];
        	
        	minintotal = Math.min(minintotal, mintillhere);
        	
        	sum+=A[i];
        }
        
        if(sum==minintotal)
        	return maxintotal;
        return Math.max(sum - maxintotal, maxintotal);
        
	}

	public static void main(String[] args) {

		MaximumSum ps = new MaximumSum();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(ps.maxSubarraySumCircular(arr));
			t--;
		}
	}
}
