package data_structures.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Here we are given one point on the chess board and we have knight, we need to
 * decide the minimum number of steps in which knight reaches that given point.
 * So here we are using the BFS approach of graph.
 */
public class KnightChessborad {

	// class to store the details of coordinates
	static class Cell {
		int x, y;
		int dis;

		public Cell(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}

	}

	// method to check if the given coordinates are in range or not
	static boolean inRange(int x, int y, int N) {
		if (x >= 1 && x <= N && y >= 1 && y <= N)
			return true;
		else
			return false;
	}

	// method to calculate the minimum distance
	static int minStepToReachTarget(int knightPos[], int targetPos[], int N) {

		// from one position a knight can move in 8 directions so here are those
		// coordinates represented in the form if dx and dy
		int dx[] = { -1, -2, 1, -2, -1, 2, 1, 2 };
		int dy[] = { -2, -1, -2, 1, 2, -1, 2, 1 };

		Cell tmp;
		int x, y;

		// similar to BFS we are using visited array to keep track of visited nodes
		boolean visited[][] = new boolean[N + 1][N + 1];

		// similar to BFS traversal in graph we are using queue here
		Queue<Cell> queue = new LinkedList<Cell>();

		queue.add(new Cell(knightPos[0], knightPos[1], 0));
		visited[knightPos[0]][knightPos[1]] = true;

		while (!queue.isEmpty()) {
			tmp = queue.remove();

			if (tmp.x == targetPos[0] && tmp.y == targetPos[1])
				return tmp.dis;

			for (int i = 0; i < 8; i++) {
				x = tmp.x + dx[i];
				y = tmp.y + dy[i];

				if (inRange(x, y, N) && !visited[x][y]) {
					visited[x][y] = true;
					queue.add(new Cell(x, y, tmp.dis + 1));
				}

			}

		}

		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		int N = 30;
		int knightPos[] = { 1, 1 };
		int targetPos[] = { 30, 30 };
		System.out.println(minStepToReachTarget(knightPos, targetPos, N));
	}
}
