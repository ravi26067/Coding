class Trie {

    class Node{
		Node [] child = new Node[26];
		boolean isWord;
		public Node() {
			for(int i = 0 ;i<child.length;i++)
				child[i] = null;
			isWord = false;
		}
	}
    
    /** Initialize your data structure here. */
    Node root;
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node temp = root;
		
		for(int i=0;i<word.length();i++) {
			int asc = word.charAt(i) - 'a';
			if(temp.child[asc]==null)
				temp.child[asc] = new Node();
			temp = temp.child[asc];
		}
		temp.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node temp = root;
		
		for(int i=0;i<word.length();i++) {
			int asc = word.charAt(i) - 'a';
			if(temp.child[asc]==null)
				return false;
			temp = temp.child[asc];
		}
		if(temp!=null && temp.isWord)
			return true;
		else
			return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node temp = root;
		
		for(int i=0;i<prefix.length();i++) {
			int asc = prefix.charAt(i) - 'a';
			if(temp.child[asc]==null)
				return false;
			temp = temp.child[asc];
		}
		return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */