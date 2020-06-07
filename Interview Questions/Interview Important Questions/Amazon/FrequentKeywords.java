import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given a list of reviews, a list of keywords and an integer k. Find the most
 * popular k keywords in order of most to least frequently mentioned.
 * 
 * The comparison of strings is case-insensitive. Multiple occurances of a
 * keyword in a review should be considred as a single mention. If keywords are
 * mentioned an equal number of times in reviews, sort alphabetically.
 */
class Solution {

	String[] reviewsFrequency(String[] reviews, String[] keywords, int k) {
		Map<String, Integer> mp = new LinkedHashMap();
		Map<String, Integer> reversedmp = new LinkedHashMap();
		String res[] = new String[k];

		for (int i = 0; i < keywords.length; i++) {
			int cnt = 0;
			for (String rev : reviews) {
				if (rev.toLowerCase().contains(keywords[i].toLowerCase())) {
					cnt++;
				}
			}
			mp.put(keywords[i], cnt);
		}
		mp.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> reversedmp.put(x.getKey(), x.getValue()));

		int i = 0;

		// System.out.println("Size:" + reversedmp.size());

		for (Entry<String, Integer> ab : reversedmp.entrySet()) {

			if (i >= k)
				break;

			res[i++] = ab.getKey();
			System.out.println(ab.getKey() + ":" + ab.getValue());
		}

		return res;
	}

	public static void main(String[] args) {
		Solution sl = new Solution();
		String reviews[] = { "I love anacell Best services; Best services provided by anacell",
				"betacellular has great services", "deltacellular provides much better services than betacellular",
				"cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
		String keywords[] = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
		String result[] = sl.reviewsFrequency(reviews, keywords, 2);
		for (String s : result)
			System.out.println(s);
	}

}