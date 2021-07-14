import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		List<List<String>> res = new ArrayList<>();
		Arrays.sort(products);
		for(int i=0;i<searchWord.length();i++)
			res.add(new ArrayList<String>());
		
		for (int i = 0; i < searchWord.length() ;i++) {
			String str = searchWord.substring(0, i+1);
			for (String product : products) {
				if(res.get(i).size()==3)
					break;
				if(product.startsWith(str))
					res.get(i).add(product);
			} 
		}
		return res;
	}

	public static void main(String[] args) {
		Solution sl = new Solution();
		String products[] = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		String searchword = "mouse";
		sl.suggestedProducts(products, searchword);
	}

}