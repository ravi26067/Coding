class Solution {
    public boolean wordPattern(String pattern, String str) {
		int len = pattern.length();
		String[] subs = str.split("\\s+");
		if (subs.length != len)
			return false;
		Map<Character, String> mp = new TreeMap();

		Map<String, Character> mp1 = new TreeMap();

		for (int i = 0; i < len; i++) {
			Character c = pattern.charAt(i);
			if (mp.containsKey(c)) {
				if (!subs[i].equals(mp.get(c)))
					return false;
			}
			mp.put(c, subs[i]);
		}

		for (int i = 0; i < len; i++) {
			Character c = pattern.charAt(i);
			if (mp1.containsKey(subs[i])) {
				if (c != mp1.get(subs[i]))
					return false;
			}
			mp1.put(subs[i], c);
		}

		return true;
	}
}