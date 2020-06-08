package data_structures.graph;

/**
 * This is simple programming of dynamic programming in which we are finding the
 * value of nCk. Here we are using two approaches: 1. Memorization 2. Tabulation
 */
public class BinomialCoefficient {

	static int binomialRec(int n, int k) {
		if (n == k || k == 0)
			return 1;

		return binomialCoef(n - 1, k - 1) + binomialCoef(n - 1, k);
	}

	// tabulation
	static int binomialCoef(int n, int k) {

		int bnc[][] = new int[n + 1][k + 1];

		for (int i = 0; i <= n; i++) {
			// Rules
			// bnc[n][n] = 1;
			// bnc[n][0] = 1;
			bnc[i][0] = 1;
			if (i <= k) {
				bnc[i][i] = 1;
			}
		}

		// b(n,k) = b(n-1,k-1) + b(n-1,k)
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				bnc[i][j] = bnc[i - 1][j] + bnc[i - 1][j - 1];
			}
		}
		return bnc[n][k];
	}

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		System.out.println("Using memorization");
		System.out.println(binomialRec(n, k));
		System.out.println("Using tabulation");
		System.out.println(binomialCoef(n, k));
	}
}
