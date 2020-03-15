package com.graph;

import java.util.*;

public class DFSearch {
	Stack<Node> st;
	 
	public DFSearch() {
		st=new Stack<>();
	}
	
	public void dfs(Node node) {
		System.out.print(node.data + " ");
		List<Node> neighbours = node.getNeighbour();
		node.visited = true;
		
		for(int i =0; i < neighbours.size() ; i++) {
			Node n = neighbours.get(i);
			if(n != null && !n.visited) {
				dfs(n);
			}
		}
	}
	
	public void topologicalSort(Node node) {
		
		List<Node> neighbours = node.getNeighbour();
		
		for(int i =0; i < neighbours.size(); i++) {
			Node n = neighbours.get(i);
			if(n != null && !n.visited) {
				topologicalSort(n);
				n.visited = true;
			}
		}
		st.push(node);
	}
	
	public void dfsStack(Node node) {
		Stack<Node> st = new Stack<Node>();
		st.add(node);
		
		while(!st.isEmpty()) {
			Node element = st.pop();
			if(!element.visited) {
				System.out.print(element.data + " ");
				element.visited = true;
			}
			List<Node> neighbours = element.getNeighbour();
			
			for(int i =0; i < neighbours.size() ; i++) {
				Node n = neighbours.get(i);
				if(n != null && !n.visited) {
					st.add(n);
				}
			}
		}
	}
	
	public void bfs(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		node.visited=true;
		
		while(!q.isEmpty()) {
			Node element = q.remove();
			System.out.print(element.data + " ");
			
			List<Node> neighbours = element.getNeighbour();
			
			for(int i =0; i < neighbours.size() ; i++) {
				Node n = neighbours.get(i);
				if(n != null && !n.visited) {
					q.add(n);
					n.visited=true;
				}
			}
		}
	}

}
