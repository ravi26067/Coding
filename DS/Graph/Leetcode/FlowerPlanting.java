import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * In this problem we have used graph DFS traversal approach. Also we have taken
 * care of the two adjacent nodes colors shouldn't be equal. Like DFS we are
 * using queue data structure and also to keep track of adjacent nodes colors we
 * are using colors array. We are storing the final result in result array and
 * also it's acting here like visited array in DFS graph.
 */
class Solution {

	public int[] gardenNoAdj(int N, int[][] paths) {
		// creation of adjacency list
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] adj = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		// filling the data in adjacency list
		for (int i = 0; i < paths.length; i++) {
			adj[paths[i][0] - 1].add(paths[i][1] - 1);
			adj[paths[i][1] - 1].add(paths[i][0] - 1);
		}

		// declaring an array for storing colors or final result
		int result[] = new int[N];

		// declaring a queue for BFS
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int j = 0; j < N; j++) {

			queue.add(j);

			while (!queue.isEmpty()) {

				int v = queue.remove();

				// this is taken to keep track of adjacent garden nodes flower colors shouldn't
				// be equal
				boolean colors[] = new boolean[5];

				// condition to avoid already colored nodes
				if (result[v] == 0) {
					Iterator<Integer> it = adj[v].listIterator();
					while (it.hasNext()) {
						int i = it.next();
						if (result[i] == 0) {
							queue.add(i);
						} else {
							colors[result[i]] = true;
						}
					}
					for (int i = 1; i < 5; i++) {
						if (!colors[i]) {
							result[v] = i;
							break;
						}
					}
				}

			}
		}

		return result;
	}

	public static void main(String[] args) {
		Solution sl = new Solution();
		int N = 5;
		int paths[][] = { { 1, 2 }, { 1, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 5 } };
		// {{1,2},{3,4}};
		int arr[] = sl.gardenNoAdj(N, paths);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

}