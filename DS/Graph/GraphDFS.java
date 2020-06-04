package data_structures.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * This is the implementation of graph traversal using DFS where we go to depth
 * first. There are two implementations here ,one is using the recursion and
 * other is iterative. In the iterative method stack is used.
 */
public class GraphDFS {

	private int V;
	private List<Integer> adj[];

	public GraphDFS(int v) {
		V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new LinkedList<Integer>();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void DFSUtil(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v + " ");

		Iterator<Integer> it = adj[v].listIterator();

		while (it.hasNext()) {
			int i = it.next();
			if (!visited[i])
				DFSUtil(i, visited);
		}

	}

	void DFS() {

		boolean visited[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i])
				DFSUtil(i, visited);
		}
		System.out.println();

	}

	void DFSIteration(int v) {
		boolean visited[] = new boolean[V];

		Stack<Integer> st = new Stack();

		st.push(v);

		while (!st.empty()) {
			v = st.pop();
			if (!visited[v]) {
				visited[v] = true;
				System.out.print(v + " ");
			}

			Iterator<Integer> it = adj[v].listIterator();
			while (it.hasNext()) {
				int i = it.next();
				if (!visited[i]) {
					st.push(i);
				}
			}

		}

		System.out.println();

	}

	public static void main(String[] args) {
		GraphDFS dfs = new GraphDFS(4);
		int arr[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 0 }, { 2, 3 }, { 3, 3 } };
		for (int i = 0; i < arr.length; i++)
			dfs.addEdge(arr[i][0], arr[i][1]);
		dfs.DFS();
		dfs.DFSIteration(2);

	}

}
