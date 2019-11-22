/**
 * Program for array rotations using two approaches.
 */
public class ArrayRotation {

	//method 1: we are taking an auxilary array of size k and sotring the first k elements there 
	//Time complexity is O(n) but extra space is used in this method O(k)
	
	static void arrayRotation(int arr[],int k) {
		int n = arr.length;
		
		int arr1[] = new int[k];
		for(int i =0 ; i<k;i++)
			arr1[i] = arr[i];
		
		for(int i = 0 ; i<n-k ; i++) {
			arr[i] = arr[i+k];
		}
		
		for(int i=n-k;i<n;i++)
			arr[i] = arr1[i- (n-k)];
		
	}
	
	
	//program to reverse array from specified positions
	static void reverseArray(int arr[],int strt,int end) {
		
		while(strt<end) {
			int temp = arr[strt];
			arr[strt] = arr[end];
			arr[end] = temp;
			strt++;
			end--;
		}
		
	}
	
	static void arrayRoatationUsingReversal(int arr[], int k) {
		int n =arr.length;
		reverseArray(arr, 0, k-1);
		reverseArray(arr, k, n-1);
		reverseArray(arr, 0, n-1);
		
	}
	
	static void printArr(int arr[]) {
		for(int i:arr) 
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7};
		printArr(arr);
		arrayRotation(arr, 2);
		printArr(arr);
		arrayRoatationUsingReversal(arr, 5);
		printArr(arr);
	}
}
