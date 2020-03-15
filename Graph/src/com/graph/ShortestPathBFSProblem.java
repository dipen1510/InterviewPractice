package com.graph;
import java.util.LinkedList;
import java.util.Queue;



public class ShortestPathBFSProblem {
	// queue node used in BFS
	static class Node
	{
		// (x, y) represents matrix cell coordinates
		// dist represent its minimum distance from the source
		int x, y, dist;

		Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	};
	// M x N matrix
		private static final int M = 10;
		private static final int N = 10;
		
		// Below arrays details all 4 possible movements from a cell
		private static final int row[] = { -1, 0, 0, 1 };
		private static final int col[] = { 0, -1, 1, 0 };

		// Function to check if it is possible to go to position (row, col)
		// from current position. The function returns false if (row, col)
		// is not a valid position or has value 0 or it is already visited
		private static boolean isValid(int mat[][], boolean visited[][],
														int row, int col)
		{
			return (row >= 0) && (row < M) && (col >= 0) && (col < N)
						   && mat[row][col] == 1 && !visited[row][col];
		}
		
		public static void BFS(int[][] mat, int i, int j, int x, int y) {
			boolean[][] visited = new boolean[M][N];
			
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(i,j,0));
			visited[i][j] = true;
			int minDist = Integer.MAX_VALUE;
			
			while(!q.isEmpty()) {
				Node node = q.poll();
				i = node.x;
				j = node.y;
				int dist = node.dist;
				if(i == x && j == y) {
					minDist = dist;
					break;
				}
				
				for(int k=0; k< 4; k++) {
					if(isValid(mat,visited,i+row[k],j+col[k])) {
						visited[i+row[k]][j+col[k]] = true;
						q.add(new Node(i + row[k], j + col[k], dist + 1));
					}
				}
			}
			
			if (minDist != Integer.MAX_VALUE) {
				System.out.print("The shortest path from source to destination "
								+ "has length " + minDist);
			}
			else {
				System.out.print("Destination can't be reached from source");
			}
			
		}
		
	public static void main(String[] args) {
		int mat[][] =
			{
					{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
					{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
					{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
					{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
					{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
					{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
					{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
					{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
					{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
					{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
			};

		// Find shortest path from source (0, 0) to
				// destination (7, 5)
				BFS(mat, 0, 0, 7, 5);

	}

}
