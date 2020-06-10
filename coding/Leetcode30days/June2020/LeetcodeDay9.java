
/**
 * We have given two strings , String s is having the word and we need to find
 * if the subsequence of word s is present in string t or not. 
 * We can use two approach here: 
 * 1.Recursion Here we will compare the first character of both
 * strings and then call recursive method again 
 * 2.Iterative Here we will compare both strings at i and j position and if they 
 * match we will increase both otherwise we will just increase j.
 */
class Solution {

	// recursive approach
	public boolean isSubsequence(String s, String t) {

		if (s.length() == 0)
			return true;
		if (t.length() == 0)
			return false;

		if (s.charAt(0) == t.charAt(0))
			return isSubsequence(s.substring(1, s.length()), t.substring(1, t.length()));
		else
			return isSubsequence(s, t.substring(1, t.length()));
	}

	// iterative approach
	public boolean isSubsequenceIt(String s, String t) {

		if (s.length() == 0)
			return true;
		if (t.length() == 0)
			return false;

		int j = 0;
		int i = 0;
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j))
				i++;
			j++;
		}

		return (i == s.length() ? true : false);
	}

	public static void main(String[] args) {
		Solution sl = new Solution();
		String s = "abg";
		String t = "abhjkhg";
		System.out.println(sl.isSubsequence(s, t));
		System.out.println(sl.isSubsequenceIt(s, t));
	}

}