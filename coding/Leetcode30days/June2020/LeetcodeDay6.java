import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Here we will have the correct input where we are given height and number of
 * people who are in front of current person who have more or equal height than
 * current person's height. So we will sort it in decreasing order of height and
 * increasing order of their priority. We will first fill the more height person
 * and then we will shift them right accordingly when smaller height comes.
 */
class Solution {

	public int[][] reconstructQueue(int[][] people) {
		List<int[]> result = new ArrayList<int[]>();

		Arrays.sort(people, (a, b) -> {
			return (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
		});

		for (int[] i : people)
			result.add(i[1], i);

		return result.toArray(new int[people.length][2]);
	}

	public static void main(String[] args) {
		Solution sl = new Solution();
		int arr[][] = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		arr = sl.reconstructQueue(arr);

		System.out.println("Printing result");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}

}