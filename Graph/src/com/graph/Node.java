package com.graph;

import java.util.*;

public class Node {
	
	int data;
	boolean visited;
	List<Node> neighbour;
	
	Node(int data){
		this.data = data;
		neighbour = new ArrayList<>();
	}
	
	public void addneighbours(Node neighbourNode) {
		this.neighbour.add(neighbourNode);
	}
	
	public List<Node> getNeighbour() {
		return neighbour;
	}
	
	public void setNeighbour(List<Node> neighbour) {
		this.neighbour = neighbour;
	}

}
