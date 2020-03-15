package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphExample {
	
	/*
	 * Other Questions
	 * 1. No of island
	 * 2. spiral matrix
	 * 3. leetcode medium bfs(shortest path) and dfs
	 */
	
	static class Graph
	{
	    private int V; // No. of vertices

	    // Array of lists for Adjacency List Representation
	    // an array of linked list
	    // in this implementation the graph vertex values will be same array index 
	    private LinkedList<Integer> adj[];

	    Graph(int v)
	    {
	        V = v;
	        adj = new LinkedList[v];
	        for (int i=0; i<v; ++i)
	            adj[i] = new LinkedList();
	    }

	    //Function to add an edge into the graph
	    void addEdge(int v, int w)
	    {
	        adj[v].add(w); // Add w to v's list.
	    }
	    
	    public static void main(String[] args) {
			Graph g = new Graph(7);
	        
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 3);
	        g.addEdge(4, 1);
	        g.addEdge(6, 4);
	        g.addEdge(6, 0);
	        g.addEdge(5, 2);
	        g.addEdge(5, 6);
	        // g.printGraph();
	        
	        /*
	         * Find a mother vertex
	         */
	        g.DFS();  // Mother Vertex
	        
			Graph graph = new Graph(5); 
			graph.addEdge(0, 1); 
	        graph.addEdge(0, 2); 
	        graph.addEdge(1, 2); 
	        graph.addEdge(2, 0); 
	        graph.addEdge(2, 3); 
	        graph.addEdge(3, 3); 
			
	        /*
	         * find the cycle
	         */
			//[1,2],[2,3],[5],[0],[5],[],[]
			Graph g1 = new Graph(7); 
	        g1.addEdge(0, 1); 
	        g1.addEdge(0, 2); 
	        g1.addEdge(1, 2); 
	        g1.addEdge(1, 3); 
	        g1.addEdge(2, 5); 
	        g1.addEdge(3, 0); 
	        g1.addEdge(4, 5);
	        g1.addEdge(5, 6);
	        //g.addEdge(6, -1);
	  
	  
	        System.out.println("Cycle Present : " + g.isCycle());
	        
	        /*
	         * oracle phone screen interview quetion
	         * return list of nodes whose not in cycle using color concept to find cycle
	         */
	        int[] color = new int[7];
	    	
	    	for(int i=0; i < 7; i++) {
	    		color[i] = 0;
	    	}
	    	g.hasCycle(color);
	        System.out.println("Cycle Present : " + g.hasCycle(color));
	        
	        for(int i = 0; i< color.length; i++) {
	        	if(color[i] == 2)
	        		System.out.println(i);
	        }
	        
	        /*
	         * no of paths between source and destination
	         */
	        int s = 0, d = 1; 
	        System.out.println("Total PathCount : " + g.countPaths(s, d)); 
	        
		}
	    
	    void DFS() {
	    	boolean[] visited = new boolean[V];
	    	int v = -1;
	    	for(int i =0; i< V; i++) {
	    		if(visited[i] == false) {
	    			DFSUtil(i,visited);
		    		v =i;
	    		}
	    	}
	    	
	    	// the node that finishes last in DFS can be the mother vertex
	        for (int i = 0; i < V; i++)
	        {
	            visited[i] = false;
	        }
	        
	        System.out.println(" Mother Vertex Detected At:"  + v);
	        
	        // we found the last finishing node
	        // need to validate that
	        // consider a individual node in the graph. It may not be the last vertex to finish.
	        // to we need to confirm that
	        DFSUtil(v, visited);
	        for(int i = 0; i < V; i++)
	        {
	            if(visited[i] == false)
	            {
	                System.out.println("Not a mother vertex.Node that wasn't connected :" + i);        
	                return;
	            }
	        }
	        System.out.println(" Mother Vertex: "  + v);
	    }
	    
	    void DFSUtil(int v , boolean[] visited) {
	    	visited[v] = true;
	    	for(Integer i : adj[v]) {
	    		if(!visited[i]) {
	    			DFSUtil(i,visited);
	    		}
	    	}
	    }
	    
	    int countPaths(int s, int d) {
	    	boolean[] visited = new boolean[V];
	    	int pathCount = 0;
	    	pathCount = countPathUtil(s,d,visited,pathCount);
	    	return pathCount;
	    	
	    }
	    
	    int countPathUtil(int s, int d, boolean[] visited, int pathCount){
	    	visited[s] = true;
	    	if(s == d) {
	    		pathCount++;
	    	}else {
	    		for(Integer i : adj[s]) {
		    		if(!visited[i]) {
		    			pathCount = countPathUtil(i,d,visited,pathCount);
		    		}
		    	}
	    		
	    	}
	    	visited[s] = false;
	    	return pathCount;
	    	
	    }
	    
	    boolean isCycyelUtil(int v, boolean[] visited, boolean[] recSeen) {
	    	
	    	if(recSeen[v])
	    		return true;
	    	if(visited[v])
	    		return false;
	    	
	    	visited[v] = true;
	    	recSeen[v] = true;
	    	
	    	for(Integer i: adj[v]) {
	    		if(isCycyelUtil(i,visited,recSeen))
	    			return true;
	    	}
	    	recSeen[v] = false;
	    	return false;
	    }
	    
	    boolean isCycle() {
	    	boolean[] visited = new boolean[V];
	    	boolean[] recSeen = new boolean[V];
	    	
	    	for(int i=0; i < V; i++) {
	    		if(isCycyelUtil(i,visited,recSeen))
	    			return true;
	    	}
	    	return false;
	    }
	    
	    boolean hasCycyelUtil(int v, int[] color, List<Integer> ans) {
	    	
	    	color[v] = 1;
	    	
	    	for(Integer i: adj[v]) {
	    		if(color[Math.abs(i)] == 2)
		    		continue;
	    		if(color[Math.abs(i)] == 1)
		    		return true;
	    		if(color[Math.abs(i)] == 0 && hasCycyelUtil(Math.abs(i),color,ans)) {
	    			return true;
	    		}
	    	}
	    	color[v] = 2;
	    	return false;
	    }
	    
	    boolean hasCycle(int[] color) {
	    	List<Integer> ans = new ArrayList<>();
	    	for(int i=0; i < V; i++) {
	    		if(color[i] == 0 && hasCycyelUtil(i,color,ans)) {
	    			return true;
	    		}
	    	}
	    	System.out.println(ans);
	    	return false;
	    }
	}
	
	

}
