package data_structures.graph;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * We are given an input array and integer k which is atmost equal to size of an
 * array, generate all possible ways we can choose k integers from array.
 * input={3,2,5,8} k = 3 output= [3,2,5],[3,2,8],[3,5,8],[2,5,8]
 */
public class GenerateKWays {

	// we will use backtracking here where we are having partial set which check for
	// the condition and if that condition fulfills then it will print the result
	public static void combination(int arr[], HashSet<Integer> set, int start, int k) {

		// The condition on which we will print the result
		if (set.size() == k) {
			System.out.println(set);
			return;
		}

		// to avoid index out of bound exception and corner cases
		if (start == arr.length)
			return;

		// here we are iterating starting from 0 - arr.length-1 with each and every
		// permutation
		for (int i = start; i < arr.length; i++) {
			set.add(arr[i]);
			combination(arr, set, i + 1, k);
			set.remove(arr[i]);
		}

	}

	// optimal solution
	public static void optimalCombination(int arr[], HashSet<Integer> set, int start, int k) {
		if (set.size() == k) {
			System.out.println(set);
			return;
		}

		// to avoid index out of bound exception and corner cases
		if (start == arr.length)
			return;

		set.add(arr[start]);
		optimalCombination(arr, set, start + 1, k);
		set.remove(arr[start]);
		optimalCombination(arr, set, start + 1, k);

	}

	public static void main(String[] args) {
		int arr[] = { 3, 2, 5, 8 };
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		int k = 3;
		combination(arr, set, 0, k);
		System.out.println("Optimal sol:");
		optimalCombination(arr, set, 0, k);
	}

}
