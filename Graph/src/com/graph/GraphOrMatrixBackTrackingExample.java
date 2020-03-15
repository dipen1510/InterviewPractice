package com.graph;
import java.util.*;

public class GraphOrMatrixBackTrackingExample {
	
	static class Node
	{
		// (x, y) represents chess board coordinates
		// dist represent its minimum distance from the source
		int x, y, dist;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	private static final int N = 8;
	// Below arrays details all 8 possible movements for a knight.
		// Don't change the sequence of below arrays
		public static final int row[] = { 2, 1, -1, -2, -2, -1,  1,  2 , 2 };
		public static final int col[] = { 1, 2,  2,  1, -1, -2, -2, -1, 1 };
	public static void main(String[] args) {
		// mat[][] keeps track of position of Queens in
				// the current configuration
				char[][] mat = new char[N][N];

				// initialize mat[][] by '-'
				for (int i = 0; i < N; i++) {
					Arrays.fill(mat[i], '-');
				}
		
			/*
			 * NQueen problem
			 */
				nQueen(mat, 0);
		
		// visited[][] serves two purpose -
				// 1. It keep track of squares involved the Knight's tour.
				// 2. It stores the order in which the squares are visited
				int visited[][] = new int[N][N];
				int pos = 1;

			/*
			 * start knight tour from corner square (0, 0)
			 */
				knightTour(visited, 0, 0, pos);
				
			/*
			 * Chess Knight shortestPAth between source to destination
			 */

				// source coordinates
				Node src = new Node(0, 7);

				// destination coordinates
				Node dest = new Node(7, 0);

				System.out.println("Minimum number of steps required is " + BFS(src, dest, N));

	}
	
	public static boolean valid(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N)
			return false;

		return true;
	}
	
	public static int BFS(Node src, Node dec, int n) {
		Set<Node> set = new HashSet<>();
		Queue<Node> q = new LinkedList<>();
		q.add(src);
		
		while(!q.isEmpty()) {
			Node node = q.remove();
			if(node.x == dec.x && node.y == dec.y)
				return node.dist;
			if(!set.contains(node)) {
				set.add(node);
				for(int i=0;i<8;i++) {
					int newX = node.x + row[i];
					int newY = node.y + col[i];
					
					if(valid(newX,newY))
						q.add(new Node(newX,newY,node.dist+1));
						
				}
			}
			
		}
		// return INFINITY if path is not possible
				return Integer.MAX_VALUE;
	}
	
	public static void print(int[][] visited) {
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean isValid(int[][] visited, int x, int y) {
		if (x < 0 || y < 0 || x >= visited.length || y >= visited[0].length)
			return false;

		return true;
	}
	
	public static void knightTour(int[][] visited, int x,int y, int pos) {
		visited[x][y]=pos;
		
		if(pos >= N*N) {
			print(visited);
			visited[x][y]=0;
			return;
		}
		
		for(int i =0; i<8;i++) {
			int newX = x+row[i];
			int newY = y+col[i];
			
			if(isValid(visited,newX,newY) && visited[newX][newY] == 0)
				knightTour(visited,newX,newY,pos+1);
		}
		visited[x][y]=0;
	}
	
	public static boolean isSafe(char[][] mat, int r, int c) {
		// return false if two queens share the same column
		for(int i=0;i<r;i++) {
			if(mat[i][c]=='Q')
				return false;
		}
		// return false if two queens share the same \ diagonal
		for(int i=r,j=c; i>=0 && j>=0;i--,j--) {
			if(mat[i][j]=='Q')
				return false;
		}
		// return false if two queens share the same / diagonal
		for(int i=r,j=c; i>=0&&j<N;i--,j++) {
			if(mat[i][j]=='Q')
				return false;
		}
		
		return true;
	}
	
	public static void nQueen(char[][] mat, int r) {
		if(r==N) {
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
					System.out.print(mat[i][j] + " ");
				System.out.println();
			}
			System.out.println();

			return;
		}
		for(int i=0; i < N; i++) {
			
			if(isSafe(mat,r,i)) {
				mat[r][i] = 'Q';
				nQueen(mat,r+1);
				mat[r][i] = '-';
			}
			
			
		}
	}

}
