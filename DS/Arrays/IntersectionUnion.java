import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntersectionUnion {

	
	public static void arrayInput(int arr[],int n) {
		System.out.println("Enter the values:");
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
	}
	
	
	public static List<Integer> union(int arr1[],int n1 , int arr2[] ,int n2) {
		List<Integer> arr = new ArrayList<Integer>();
		
		int i=0,j=0;
		while (i<n1&&j<n2) {
			if(arr1[i]<arr2[j])
				arr.add(arr1[i++]);
			else if(arr1[i]>arr2[j])
				arr.add(arr2[j++]);
			else {
				arr.add(arr1[i++]);
				j++;
			}
		}
		while(i<n1)
			arr.add(arr1[i++]);
		while(j<n2)
			arr.add(arr2[j++]);
		
		return arr;
	}
	
	public static void printArr(int arr[],int n) {
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	public static void printList(List arr) {
		for(int i=0;i<arr.size();i++)
			System.out.print(arr.get(i)+" ");
		System.out.println();
	}
	
	public static List<Integer> intersection(int arr1[],int n1 , int arr2[] ,int n2){
		
		List<Integer> arr = new ArrayList<Integer>();
		
		int i=0,j=0;
		while (i<n1&&j<n2) {
			if(arr1[i]<arr2[j])
				i++;
			else if(arr1[i]>arr2[j])
				j++;
			else {
				arr.add(arr1[i++]);
				j++;
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of first array: ");
		int n1 = sc.nextInt();
		int [] arr1 = new int[n1];
		arrayInput(arr1, n1);
		System.out.println("Enter size of second array: ");
		int n2 = sc.nextInt();
		int [] arr2 = new int[n2];
		arrayInput(arr2, n2);
		List<Integer> arrUnion = union(arr1, n1, arr2, n2);
		System.out.println("Printing union of two sorted arrays");
		printList(arrUnion);
		List<Integer> arrInt = intersection(arr1, n1, arr2, n2);
		System.out.println("Printing intersection of two sorted arrays");
		printList(arrInt);
	}

}
