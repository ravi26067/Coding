import java.util.Scanner;

public class PerfectSquare {

	
	public boolean isPerfectSquare(int num) {
		long lef = 0;
		long r = num;
		System.out.println(num);
		int cnt = 1;

		if (num == 0)
			return false;

		while (lef <= r) {
			long mid = (r - lef) / 2 + lef;
			System.out.println("Count :" + cnt++ + " mid val: " + mid + " left: "+ lef + " right: "+r);
			if (mid * mid == num)
				return true;

			if ((mid * mid) < num)
				lef = mid + 1;
			else
				r = mid - 1;
		}
		return false;
	}

	
	public static void main(String[] args) {

		PerfectSquare ps = new PerfectSquare();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			System.out.println(ps.isPerfectSquare(n));
			t--;
		}
	}
}
