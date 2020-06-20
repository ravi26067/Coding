import java.util.ArrayList;
import java.util.List;

/**
 * We can have n! Permutations for n, so we will find the first digit , 2nd
 * digit and so on using k and factorial of n-1. So if we have n=5 , which has
 * 120 permutations, we can have either of 1,2,3,4,5 on first position. As we
 * know that 5*4! = 120 so we can have value of k from 1 to 120 so we are
 * dividing k by 4! so that it will give the value of first index from 1 to 5.
 * Then we will update the value of k by doing modulo of k by fact(n-1) and
 * repeat this process.
 */
public class Solution {

	public String getPermutation(int n, int k) {
		List<Integer> ls = new ArrayList();
		int fact[] = new int[n];

		fact[0] = 1;
		for (int i = 1; i <= n; i++) {
			fact[i] = i * fact[i - 1];
			ls.add(i);
		}
		k--;
		String s = "";
		for (int i = n - 1; i >= 0; i--) {
			int index = k / fact[i];
			System.out.println("k:" + k + " i:" + i + " fact[i]:" + fact[i] + " index:" + index);
			s = s + ls.remove(index);
			for (int k1 : ls)
				System.out.print(k1 + " ");
			System.out.println();

			k = k % fact[i];
		}
		return s;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 5;
		int k = 10;
		System.out.println(sol.getPermutation(n, k));
	}

}