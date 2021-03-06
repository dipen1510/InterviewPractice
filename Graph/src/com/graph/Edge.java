package com.graph;

public class Edge {
	
	private double weight;
	private Vertex sourceVertex;
	private Vertex targetVertex;
	
	
	
	public Edge(double weight, Vertex sourceVertex, Vertex targetVertex) {
		
		this.sourceVertex = sourceVertex;
		this.targetVertex = targetVertex;
		this.weight = weight;
	}
	
	public Vertex getSourceVertex() {
		return sourceVertex;
	}
	public void setSourceVertex(Vertex sourceVertex) {
		this.sourceVertex = sourceVertex;
	}
	public Vertex getTargetVertex() {
		return targetVertex;
	}
	public void setTargetVertex(Vertex targetVertex) {
		this.targetVertex = targetVertex;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	

}
