import java.util.Scanner;

public class LeetcodeContest {

	public int maxPower(String s) {

		int currmax = 1;
		int totmax = 0;

		if (s.length() == 1)
			return 1;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1))
				currmax++;
			else
				currmax = 1;

			if (currmax > totmax)
				totmax = currmax;
		}

		return totmax;
	}

	public static void main(String[] args) {

		LeetcodeContest lc = new LeetcodeContest();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while (t > 0) {
			String str = sc.nextLine();
			System.out.println(lc.maxPower(str));
			t--;
		}

	}
}
