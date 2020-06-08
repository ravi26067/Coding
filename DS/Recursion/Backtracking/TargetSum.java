package data_structures.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class TargetSum {

	public static void combinationSum(int arr[], int target) {
		Arrays.sort(arr);
		targetSum(arr, new ArrayList<Integer>(), 0, 0, target);
	}

	public static void targetSum(int arr[], ArrayList<Integer> partial, int start, int partialSum, int sum) {
		if (partialSum == sum) {
			for (int i : partial) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		if (start == arr.length)
			return;

		partial.add(arr[start]);
		targetSum(arr, partial, start + 1, partialSum + arr[start], sum);
		partial.remove(partial.size() - 1);
		// to avoid duplicate results
		while (start < arr.length - 1 && arr[start] == arr[start + 1])
			start++;
		targetSum(arr, partial, start + 1, partialSum, sum);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 1, 2, 2, 4, 5, 6, 7, 10 };
		ArrayList<Integer> partial = new ArrayList<Integer>();
		int sum = 8;
		targetSum(arr, partial, 0, 0, sum);
	}
}
