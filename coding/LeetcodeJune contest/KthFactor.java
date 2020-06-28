class Solution {
    public int kthFactor(int n, int k) {

		List<Integer> fact = new ArrayList();

		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				fact.add(i);
		}

		if (fact.size() < k)
			return -1;
		else
			return fact.get(k - 1);

	}
}