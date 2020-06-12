import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

	private List<Integer> ls;
	private Map<Integer, Integer> hm;
	/** Initialize your data structure here. */
	public RandomizedSet() {
		ls = new ArrayList();
		hm = new HashMap();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {

		if (hm.containsKey(val))
			return false;

		ls.add(val);
		hm.put(val, ls.size()-1);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		
		if(!hm.containsKey(val))
			return false;
		
		int index = hm.get(val);
		

		int last = ls.get(ls.size() - 1);
		ls.set(index, last);
		hm.put(last, index);
		ls.remove(ls.size() - 1);
		hm.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		Random rd = new Random();
		int index = rd.nextInt(ls.size());
		return ls.get(index);
	}

	public static void main(String[] args) {
		RandomizedSet obj = new RandomizedSet();
		// System.out.println("Insert: "+obj.insert(5));
		System.out.println("Remove: " + obj.remove(0));
		System.out.println("Remove: " + obj.remove(0));
		System.out.println("Insert: " + obj.insert(0));
		System.out.println("Random: " + obj.getRandom());
		System.out.println("Remove: " + obj.remove(0));
		System.out.println("Insert: " + obj.insert(0));
	}

}