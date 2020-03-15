package com.trie;

import java.util.*;

public class TrieSolution {
	
	//Trie root = new Trie();
	
	
	public static void insert(String word, Trie head) {
		// start from root node
				Trie node = head;

				// do for each character in the String
				for (int i = 0; i < word.length(); i++)
				{
					// create a new node if path doesn't exists
					if (node.children[word.charAt(i) - 'a'] == null) {
						node.children[word.charAt(i) - 'a'] = new Trie();
					}

					// go to next node
					node = node.children[word.charAt(i) - 'a'];
				}

				// mark last node as leaf
				node.endOfWord = true;
		
	}
	
	public static boolean search(String word, Trie root) {
		
		//Trie cur = root;
		
		
		for(int i=0;i<word.length();i++) {
			char ch = word.charAt(i);
			Trie node = root.children[ch-'a'];
			if( node == null) {
				return false;
			}
			root = node;
		}
		return root.endOfWord;
		
	}
	
	// Function to determine if String can be segmented into a
		// space-separated sequence of one or more dictionary words
		public static boolean wordBreaktest(Trie head, String str)
		{
			// good[i] is true if the first i characters of str can be segmented
			boolean[] good = new boolean[str.length() + 1];
			good[0] = true; // base case

			for (int i = 0; i < str.length(); i++)
			{
				if (good[i])
				{
					Trie node = head;
					for (int j = i; j < str.length(); j++)
					{
						if (node == null) {
							break;
						}

						node = node.children[str.charAt(j) - 'a'];

						// we can make [0, i] using our known decomposition,
						// and [i+1, j] using this String in trie
						if (node != null && node.endOfWord) {
							good[j + 1] = true;
						}
					}
				}
			}


			// System.out.println(Arrays.toString(str));
			// System.out.println(Arrays.toString(good));

			// good[n] would be true if all characters of str can be segmented
			return good[str.length()];
		}
		
	public static boolean bfs(char[] charArray, int startIndex, Trie root) {
		
		Queue<Trie> queue = new LinkedList<>();
	    queue.add(root);
	    
	    boolean[] visited = new boolean[charArray.length];
	    
	    while(!queue.isEmpty() && startIndex < charArray.length) {
	        
	        int size = queue.size();
	                    
	        for(int i=0;i<size;i++){
	            Trie t = queue.poll();    
	             if(t.children[charArray[startIndex]-'a'] != null){
	                queue.add(t.children[charArray[startIndex]-'a']);
	                if(t.children[charArray[startIndex]-'a'].endOfWord && !visited[startIndex]){
	                    queue.add(root);
	                    visited[startIndex] = true;
	                }
	           
	            }
	        }
	        
	        if(queue.size() != 0)
	            startIndex++;        
	       
	    }
	            
	    if(startIndex == charArray.length && visited[startIndex-1]){
	        return true;
	    }
	    
	    return false;
	}
	
	public boolean wordBreak(String s, List<String> wordDict) {
	    
	    Trie t = new Trie();
	    
	    for(String word:wordDict){
	        insert(word,t);
	    }
	    
	    //return wordBreaktest(t,s);
	    		return bfs(s.toCharArray(), 0, t);
	    
	}

}
