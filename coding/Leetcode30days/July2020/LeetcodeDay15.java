class Solution {
    public String reverseWords(String s) {
		Stack<String> str = new Stack();

		String word = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				if (word != "") {
					str.push(word);
					word = "";
				}
			} else {
				word += s.charAt(i);
			}
		}
		if (word != "")
			str.push(word);
        
		s = "";
		while (!str.isEmpty()) {
			word = str.pop();
			s += word;
			if (!str.isEmpty())
				s += " ";
		}
		return s;
	}
}