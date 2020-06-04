package data_structures.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * We are given two knights, here we need to return the knight who can reach the
 * target in minimum number of steps. This problem is same as Knight chessboard
 * problem. We are using BFS here.
 */
public class ChessboardKnights {

	static class Cell {
		int x, y;
		int dis;

		public Cell(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}

	static boolean inRange(int x, int y, int N) {
		if (x >= 1 && x <= N && y >= 1 && y <= N)
			return true;
		return false;
	}

	static int findDistance(int pos[], int target[], int N) {

		int dx[] = { -1, -2, 1, -2, -1, 2, 1, 2 };
		int dy[] = { -2, -1, -2, 1, 2, -1, 2, 1 };

		boolean visited[][] = new boolean[N + 1][N + 1];

		Cell temp;
		Queue<Cell> queue = new LinkedList<Cell>();
		queue.add(new Cell(pos[0], pos[1], 0));
		visited[pos[0]][pos[1]] = true;

		while (!queue.isEmpty()) {
			temp = queue.remove();

			if (temp.x == target[0] && temp.y == target[1])
				return temp.dis;

			for (int i = 0; i < 8; i++) {
				int x = temp.x + dx[i];
				int y = temp.y + dy[i];

				if (inRange(x, y, N) && !visited[x][y]) {
					visited[x][y] = true;
					queue.add(new Cell(x, y, temp.dis + 1));
				}

			}

		}

		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		int N = 30;
		int src1[] = { 1, 1 };
		int src2[] = { 29, 29 };
		int target[] = { 14, 15 };
		int res1 = findDistance(src1, target, N);
		int res2 = findDistance(src2, target, N);
		if (res1 < res2)
			System.out.println("Kinght1 will take min steps: " + res1);
		else
			System.out.println("Kinght2 will take min steps: " + res2);
	}
}
