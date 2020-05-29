/**
 * @author ravik Here if we will se there is a pattern. So we will not compute
 *         every result. We will use the left shift operator and then check if
 *         that number index is already set or not, if it is set then we will
 *         add that to result and return the answer otherwise we will iterate.
 */
public class BitsCount {

	private int countOnes(int num, int arr[]) {
		int ans = 0;
		while (num > 0) {
			int digit = num % 2;
			if (digit == 1)
				ans++;
			num = num >> 1;

			if (arr[num] > 0) {
				ans += arr[num];
				return ans;
			}
		}
		return ans;
	}

	public int[] countBits(int num) {
		int arr[] = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			arr[i] = countOnes(i, arr);
			System.out.println(arr[i]);
		}
		return arr;
	}

	public static void main(String[] args) {
		BitsCount btc = new BitsCount();
		int num = 15;
		int ans[] = btc.countBits(num);

		for (int i = 0; i < ans.length; i++)
			System.out.print(ans[i] + " ");
		System.out.println();
	}

}
