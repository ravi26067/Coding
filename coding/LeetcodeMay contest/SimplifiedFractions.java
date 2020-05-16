import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LeetcodeContest {

	public List<String> simplifiedFractions(int n) {
		List<String> ls = new ArrayList<String>();
		Map<Double, String> mp = new LinkedHashMap<>();

		if (n == 1)
			return ls;

		for (int i = 1; i <= n; i++) {
			String tmp;
			for (int j = i + 1; j <= n; j++) {
				if (i < j) {
					tmp = Integer.toString(i) + "/" + Integer.toString(j);
					double key = (double) i / j;
					if (!mp.containsKey(key))
						mp.put(key, tmp);
				}
			}

		}
		
		ls = new ArrayList<String>(mp.values());
		return ls;
	}

	public static void main(String[] args) {

		LeetcodeContest lc = new LeetcodeContest();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			List<String> ls = lc.simplifiedFractions(n);
			System.out.println(ls.toString());
			t--;
		}

	}
}
