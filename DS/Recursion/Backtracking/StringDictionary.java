package data_structures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given a string s and dictionary containing list of words,write a method to
 * break string completely into valid words. Print all such possible sentences.
 * The same word in dictionary may be used multiple times. 
 * E.g: I/p-"catsanddog" , dict = ["cat","cats","and","sand","dog"] 
 * output:[cat, sand,dog] [cats, and, dog]
 */
public class StringDictionary {

	public static void wordBreak(String input, HashSet<String> dict, List<String> partial) {
		// if input size if zero that means all the input is covered so we will print
		// the string
		if (input.length() == 0) {
			System.out.println(Arrays.toString(partial.toArray()));
			return;
		}

		// here we will check by including character one by one and check its presence
		// in dictionary ,if it is present then we will include it dictionary
		for (int i = 0; i < input.length(); i++) {
			String word = input.substring(0, i + 1);
			if (dict.contains(word)) {
				partial.add(word);
				wordBreak(input.substring(i + 1), dict, partial);
				partial.remove(partial.size() - 1);
			}
		}

	}

	public static void main(String[] args) {
		String input = "catsanddog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("dog");
		dict.add("sand");
		wordBreak(input, dict, new ArrayList<String>());
	}
}
