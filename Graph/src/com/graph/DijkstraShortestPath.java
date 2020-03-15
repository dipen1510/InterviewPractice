package com.graph;

import java.util.*;

public class DijkstraShortestPath {
	
	public void computeShortestPath(Vertex source) {
		
		source.setDistance(0);
		
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		
		pq.add(source);
		source.setVisited(true);
		
		while(!pq.isEmpty()) {
			Vertex actualVertex = pq.remove();
			
			for(Edge edge : actualVertex.getAdjacenciesList()) {
				
				Vertex v = edge.getTargetVertex();
				if(!v.isVisited()) {
					double newDistance = actualVertex.getDistance() + edge.getWeight();
					if(newDistance < v.getDistance()) {
						v.setDistance(newDistance);
						v.setPredecessor(actualVertex);
						pq.add(v);
						
					}
				}
				
			}
			actualVertex.setVisited(true);
		}
	}
	
	public List<Vertex> getShortestPathTo(Vertex targetVertex){
		List<Vertex> path = new ArrayList<>();
 
		for(Vertex vertex=targetVertex;vertex!=null;vertex=vertex.getPredecessor()){
			path.add(vertex);
		}
 
		Collections.reverse(path);
		return path;
	}

}
