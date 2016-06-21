// Simple implementation of Trie

import java.util.HashMap;

public class Trie {
	public class TrieNode {
		
		public HashMap<Character, TrieNode> map;
		public boolean isEnd;
		
		public TrieNode() {
			map = new HashMap<Character, TrieNode>();
			isEnd = false;
		}
	}
	
	public TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insertWord(String s) {
		if(s == null || s.length() == 0) {
			return;
		}
		TrieNode n = root;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(n.map.get(c) == null) {
				TrieNode t = new TrieNode();
				n.map.put(c, t);
			}
			
			n = n.map.get(c);
		}
		
		n.isEnd = true;
	}
	
	public boolean findWord(String s) {
		TrieNode n = root;
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(n.map.get(c) == null) {
				return false;
			}
			n = n.map.get(c);
		}
		
		if(n.isEnd == false) return false;
		
		return true;
	}

	public static void main(String[] args) {
		Trie t = new Trie();
		t.insertWord("abcd");
		t.insertWord("abc");
		t.insertWord("varun");
		t.insertWord("tarun");
		t.insertWord("victor");
		t.insertWord("bcde");
		System.out.println(t.findWord("abc"));
		System.out.println(t.findWord("abcd"));
		System.out.println(t.findWord("varun"));
		System.out.println(t.findWord("varu"));
		System.out.println(t.findWord("ab"));

	}

}
