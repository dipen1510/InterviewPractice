package com.graph;

import java.util.*;

public class Vertex implements Comparable<Vertex>{
	
	private String name;
	private boolean visited;
	private List<Edge> adjacenciesList;
	private Vertex predecessor;
	private double distance = Double.MAX_VALUE;
	
	public Vertex(String name) {
		this.name = name;
		this.adjacenciesList = new ArrayList<>();
	}
	
	public void addNeighbour(Edge edge) {
		this.adjacenciesList.add(edge);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public List<Edge> getAdjacenciesList() {
		return adjacenciesList;
	}
	public void setAdjacenciesList(List<Edge> adjacenciesList) {
		this.adjacenciesList = adjacenciesList;
	}
	public Vertex getPredecessor() {
		return predecessor;
	}
	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(Vertex otherVertex) {
		
		return Double.compare(this.distance, otherVertex.getDistance());
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name + "]";
	}
	
}
