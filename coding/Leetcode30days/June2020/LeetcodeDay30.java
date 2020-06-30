import java.util.ArrayList;
import java.util.List;

/**
 * We need to create the trie data structure from the result array. After that
 * we are using the dfs on the matrix and comparing it with word in trie.
 */
public class Solution {

	class TrieNode {

		TrieNode[] children;
		String word;

		public TrieNode() {
			children = new TrieNode[26];
		}
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
		if (board == null || board.length == 0)
			return res;

		TrieNode root = new TrieNode();

		buildTrie(root, words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char c = board[i][j];
				if (root.children[c - 'a'] != null)
					dfs(board, i, j, root, res);
			}
		}
		return res;
	}

	private void dfs(char[][] board, int i, int j, TrieNode curr, List<String> res) {
		if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1)
			return;

		if (board[i][j] == '#')
			return;

		char c = board[i][j];

		if (curr.children[c - 'a'] == null)
			return;

		curr = curr.children[c - 'a'];
		if (curr.word != null) {
			res.add(curr.word);
			curr.word = null;
		}

		board[i][j] = '#';
		dfs(board, i + 1, j, curr, res);
		dfs(board, i - 1, j, curr, res);
		dfs(board, i, j + 1, curr, res);
		dfs(board, i, j - 1, curr, res);
		board[i][j] = c;
	}

	private void buildTrie(TrieNode root, String[] words) {

		for (String s : words) {
			TrieNode curr = root;

			for (char c : s.toCharArray()) {
				int index = (int) (c - 'a');

				if (curr.children[index] == null)
					curr.children[index] = new TrieNode();

				curr = curr.children[index];

			}
			curr.word = s;
		}

	}

}