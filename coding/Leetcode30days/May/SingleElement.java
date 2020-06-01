import java.util.Scanner;

public class SingleElement {

	public int singleNonDuplicate(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		if (r == 0)
			return nums[r];

		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (mid == nums.length - 1 || mid == 0 || (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]))
				return nums[mid];
			else {
				if (nums[mid] != nums[mid - 1]) {
					if ((r - mid + 1) % 2 != 0)
						l = mid;
					else
						r = mid - 1;
				} else {
					if ((r - mid) % 2 == 0)
						r = mid;
					else
						l = mid + 1;
				}
			}
		}

		return 0;
	}

	/*
	 * int nonDuplicate(int nums[], int l, int r) {
	 * 
	 * return 0; }
	 */

	public static void main(String[] args) {

		SingleElement ps = new SingleElement();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(ps.singleNonDuplicate(arr));
			t--;
		}
	}
}
