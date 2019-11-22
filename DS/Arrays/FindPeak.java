
/**
 * We have to find the peak element of array.So we are using the divide and conquer method. We will check if mid is first elment and 
 * last element and if it's greater then it's neighbour we will return its index. 
 * If not so then we will se if left element of mid is greater then we will check peak in left subarray else in right subarray.
 */
public class FindPeak {
	
	//We are using divide and conquer
	static int findPeak(int arr[],int low , int high, int n) {
		
		int mid = low + (high-low)/2;
		
		if((mid==0 || arr[mid]>=arr[mid-1] )&& (mid ==n-1 || arr[mid]>= arr[mid+1]))
			return mid;
		else if(mid>0 && arr[mid]< arr[mid-1])
			return findPeak(arr, low, mid-1, n);
		else
			return findPeak(arr, mid+1, high, n);
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,8,9};
		int n = arr.length;
		int res = findPeak(arr, 0, n-1, n);
		System.out.println("Peak element is: "+ arr[res]);
	}
	
}