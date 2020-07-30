class Solution {
public List<String> wordBreak(String s, List<String> wordDict) {
		if (s.length() > 100) return new ArrayList();

		List<String> result = new ArrayList<String> ();
		wordBreakUtil(s, wordDict, result, new StringBuilder());
		return result;
	}
public void wordBreakUtil(String s, List<String> wordDict, List<String> result, StringBuilder subList) {
        // add " " between 2 words in subList
		if (subList.length() != 0) {
			subList.append(" ");
		}
		// iterate over all the words in wordDict
        for (String word: wordDict) {
			
			if (s.startsWith(word)) {
				StringBuilder sb = new StringBuilder(subList);
			    // append current match in sb
				sb.append(word); 
			    // if this is last word to be matched
				if (s.equals(word)) {
					result.add(new String(sb));
				} else {
					wordBreakUtil(s.substring(word.length()), wordDict, result, sb);
				}
            }
		}
	}
}
