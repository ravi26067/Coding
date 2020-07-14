/**
 * Here we have to check if string needle if substring of string haystack. If it
 * is then we have to return the first substring's first char index.
 */
class Solution {

	public int strStr(String haystack, String needle) {

		int l1 = haystack.length();
		int l2 = needle.length();

		if (l1 == l2 && (l1 == 0 || haystack.equals(needle)))
			return 0;

		if (!haystack.contains(needle) || l1 == 0 || l2 > l1)
			return -1;
		if (l2 == 0)
			return 0;

		int res = -1;

		for (int i = 0; i < (l1 - l2) + 1; i++) {
			if (haystack.charAt(i) == needle.charAt(0) && haystack.substring(i, i + l2).equals(needle))
				return i;
		}

		return res;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		String haystack = "mississippi";
		String needle = "pi";
		System.out.println(sol.strStr(haystack, needle));
	}

}
