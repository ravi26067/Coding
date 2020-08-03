class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int i = 0;
		int j = s.length()-1;
		while(i<s.length() && j>=0 && i<=j) {
			if(s.charAt(i) != s.charAt(j))
				return false;
            i++;
            j--;
		}
		return true;
    }
}