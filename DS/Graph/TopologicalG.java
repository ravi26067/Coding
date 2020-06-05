import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Logic: If some other vertex is dependent on current vertex, go to that vertex
 * first and then come back to current vertex ,else push current vertex in
 * stack.
 */
public class TopologicalG {

	private int V;
	private LinkedList<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public TopologicalG(int v) {
		V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new LinkedList<Integer>();

	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	// recursice method for backtracking
	void topologicalVisit(int v, boolean[] visited, Stack<Integer> st) {
		Iterator<Integer> it = adj[v].listIterator();
		while (it.hasNext()) {
			int i = it.next();
			if (!visited[i]) {
				topologicalVisit(i, visited, st);
			}
		}
		if (!visited[v]) {
			st.push(v);
			visited[v] = true;
		}

	}

	// here is logic to start from given node v to all other nodes and calling
	// recursive method. We will push that node first which on which no other node
	// is dependent.
	void topologicalSort(int v) {
		boolean visited[] = new boolean[V];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = v; i < V + v; i++) {
			int u = i % V;
			topologicalVisit(u, visited, st);
		}

		while (!st.empty()) {
			System.out.print(st.pop() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[][] = { { 0, 2 }, { 1, 2 }, { 1, 3 }, { 2, 4 }, { 4, 7 }, { 4, 5 }, { 3, 5 }, { 5, 6 } };
		TopologicalG tGraph = new TopologicalG(8);
		for (int i = 0; i < arr.length; i++)
			tGraph.addEdge(arr[i][0], arr[i][1]);

		tGraph.topologicalSort(0);
	}

}
