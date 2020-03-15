package com.trie;

import java.util.*;

public class Trie {
	Trie[] children;
	boolean endOfWord;
	
	public Trie() {
		children = new Trie[26];
		endOfWord = false;
	}

	@Override
	public String toString() {
		return "Trie [children=" + Arrays.toString(children) + ", endOfWord=" + endOfWord + "]";
	}
	
}
