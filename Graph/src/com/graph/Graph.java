package com.graph;

import java.util.Stack;

public class Graph {
	
	public static void main(String[] args) {
		Node node40 =new Node(40);
		Node node10 =new Node(10);
		Node node20 =new Node(20);
		Node node30 =new Node(30);
		Node node60 =new Node(60);
		Node node50 =new Node(50);
		Node node70 =new Node(70);
 
		node40.addneighbours(node10);
		node40.addneighbours(node20);
		node10.addneighbours(node30);
		node20.addneighbours(node10);
		node20.addneighbours(node30);
		node20.addneighbours(node60);
		node20.addneighbours(node50);
		node30.addneighbours(node60);
		node60.addneighbours(node70);
		node50.addneighbours(node70);
		
		System.out.println("DFS");
		
		DFSearch df = new DFSearch();
		
		/*
		 * DFS traverse
		 */
		df.dfs(node40);
		
		node40.visited=false;
		node10.visited=false;
		node20.visited=false;
		node30.visited=false;
		node60.visited=false;
		node50.visited=false;
		node70.visited=false;
		System.out.println();
		System.out.println("Topological sort");
		
		/*
		 * topological sort
		 */
		df.topologicalSort(node40);
		
		Stack<Node> ans = df.st;
		
		while(!ans.empty()) {
			System.out.print(ans.pop().data + " ");
		}
		
		node40.visited=false;
		node10.visited=false;
		node20.visited=false;
		node30.visited=false;
		node60.visited=false;
		node50.visited=false;
		node70.visited=false;
		System.out.println();
		System.out.println("DFS stack");
		
		/*
		 * dfs using stack
		 */
		df.dfsStack(node40);
		
		node40.visited=false;
		node10.visited=false;
		node20.visited=false;
		node30.visited=false;
		node60.visited=false;
		node50.visited=false;
		node70.visited=false;
		System.out.println();
		System.out.println("BFS");
		
		/*
		 * bfs traverse
		 */
		df.bfs(node40);
		
		System.out.println();
		System.out.println("Dijkstra Shortest Path");
		
		Vertex vertexA = new Vertex("A");
		Vertex vertexB = new Vertex("B");
		Vertex vertexC = new Vertex("C");
		Vertex vertexD = new Vertex("D");
		Vertex vertexE = new Vertex("E");
		
		vertexA.addNeighbour(new Edge(10,vertexA,vertexC));
		vertexA.addNeighbour(new Edge(17,vertexA,vertexB));
		vertexC.addNeighbour(new Edge(5,vertexC,vertexB));
		vertexC.addNeighbour(new Edge(9,vertexC,vertexD));
		vertexC.addNeighbour(new Edge(11,vertexC,vertexE));
		vertexB.addNeighbour(new Edge(1,vertexB,vertexD));
		vertexD.addNeighbour(new Edge(6,vertexD,vertexE));
		
		DijkstraShortestPath dij = new DijkstraShortestPath();
		
		/*
		 * Dijstra alogo
		 */
		dij.computeShortestPath(vertexA);
		
		System.out.println("Shortest Path from A to E: "+dij.getShortestPathTo(vertexE));
	}

}
