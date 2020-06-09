class Solution {

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

	public static void main(String[] args) {
		Solution sl = new Solution();
		String s = "rjufvjafbxnbgriwgokdgqdqewn";
		String t = "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq";
		System.out.println(sl.isSubsequence(s, t));
	}

}