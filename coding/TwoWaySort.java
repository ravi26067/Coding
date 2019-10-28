import java.util.Arrays;
import java.util.Collections;

public class TwoWaySort {

	
	public static void twoWaySort(int arr[]) {
		
		int n = arr.length;
		
		for(int i = 0 ;i < n ;i++) {
			if(arr[i]%2!=0)
				arr[i]*= -1;
		}
		
		Arrays.sort(arr);
		
		for(int i = 0 ;i < n ;i++) {
			if(arr[i]%2!=0)
				arr[i]*= -1;
		}
	}
	
	
	public static void printArr(int arr[]) {
		int n = arr.length;
		for(int i =0 ;i<n;i++)
			System.out.print(arr[i]+ " ");
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		
		int arr[] = {3,1,4,9,2,8,7,6};
		printArr(arr);
		twoWaySort(arr);
		printArr(arr);
	}

}