package data_structures.graph;


/**
 * Recursive solution to check if numbers are in sequence or not
 */
public class ArraySequence {

	
	static boolean checkSeq(int arr[],int n) {
		return n==arr.length-1 || (arr[n+1] - arr[n] == 1 && checkSeq(arr, n+1));
	}
	
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8};
		System.out.println("Sequence: "+ checkSeq(arr, 0));
	}

}
