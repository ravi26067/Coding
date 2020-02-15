/**
 * @author kumarr144
 * This is the basic implementation of trie data structure. Here we are storing word in the tree node. We are traversing the tree
 * from top to bottom to insert and search the word. We have taken array of size 26 and for each word we are calculating ascii and 
 * fill the position(index) of array present in the particular node.After the string completes we are setting isWord boolean true.
 */
public class Trie {

	static class Node{
		Node [] child = new Node[26];
		boolean isWord;
		public Node() {
			for(int i = 0 ;i<child.length;i++)
				child[i] = null;
			isWord = false;
		}
	}
	
	public void insert(Node root,String str) {
		Node temp = root;
		
		for(int i=0;i<str.length();i++) {
			int asc = str.charAt(i) - 'a';
			if(temp.child[asc]==null)
				temp.child[asc] = new Node();
			temp = temp.child[asc];
		}
		temp.isWord = true;
	}
	
	public boolean search(Node root,String str) {
		
		Node temp = root;
		
		for(int i=0;i<str.length();i++) {
			int asc = str.charAt(i) - 'a';
			if(temp.child[asc]==null)
				return false;
			temp = temp.child[asc];
		}
		if(temp!=null && temp.isWord)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		Trie tr = new Trie();
		Node root = new Node();
		tr.insert(root, "ravi");
		tr.insert(root, "rahul");
		tr.insert(root, "priya");
		tr.insert(root, "priyanka");
		System.out.println("Word found status: "+ tr.search(root, "priyan"));
	}

}