package data_structures.graph;

/**
 * This is recursive code to calculate the sum of digits of integer.
 */
public class DigitsSum {

	static int sum(int num) {
		if (num / 10 == 0)
			return num;
		return num % 10 + sum(num / 10);
	}

	public static void main(String[] args) {
		int num = 123456;
		System.out.println(sum(num));
	}

}
