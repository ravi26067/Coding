import java.util.Stack;

public class NearestSmallerElement {

	// Function to print nearest smaller elements for each
	// element in the array
	static void printNSE(int[] arr)
	{
		int n = arr.length;
		Stack<Integer> stack
			= new Stack<>(); // Stack to store indices of
							// elements
		int[] ans
			= new int[n]; // Array to store the results

		// Iterate through each element in the array
		for (int i = 0; i < n; i++) {
			int next = arr[i];

			// Pop elements from the stack and update
			// results for elements with smaller neighbors
			while (!stack.isEmpty()
				&& arr[stack.peek()] > next) {
				ans[stack.pop()] = next;
			}

			// Push the current index onto the stack
			stack.push(i);
		}

		// For remaining elements in the stack, set their
		// result to -1
		while (!stack.isEmpty()) {
			ans[stack.pop()] = -1;
		}

		// Print the original array elements and their
		// corresponding nearest smaller elements
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i] + " --> " + ans[i]);
		}
	}

	// Driver program to test the function
	public static void main(String[] args)
	{
		int[] arr = { 11, 13, 21, 3 };
		printNSE(arr);
	}
}
