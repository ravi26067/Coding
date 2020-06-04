package data_structures.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Like in trees we see BFS traversal is basically level order traversal where
 * you cover all nodes level by level. Here also we are doing same thing. We can
 * start from any node and we will push all the unvisited neighbors to queue
 * until the queue becomes empty.
 */
public class GraphBFS {
	private int V;
	private LinkedList<Integer> adj[];

	public GraphBFS(int v) {
		V = v;
		// initializing the adjacency list in constructor
		adj = new LinkedList[V];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void BFS(int s) {
		boolean visited[] = new boolean[V];

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(s);
		visited[s] = true;
		while (!queue.isEmpty()) {

			s = queue.remove();
			System.out.print(s + " ");

			// get all the adjacent unvisited nodes and push them into queue
			Iterator<Integer> it = adj[s].listIterator();
			while (it.hasNext()) {
				int i = it.next();
				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}

		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Given a graph in array form
		int arr[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 0 }, { 2, 3 }, { 3, 3 } };
		int len = arr.length;

		// creating an adjacency list
		GraphBFS graph = new GraphBFS(len);
		for (int i = 0; i < len; i++)
			graph.addEdge(arr[i][0], arr[i][1]);
		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		// doing bfs
		graph.BFS(2);
	}

}
