import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author kumarr144
 * This is BFS. Its similar to tree bfs but the only difference is that here cycle is present. So we will take one queue and one 
 * visited array which contain 0's and 1's. If the node is visited , it will set it as 1 else 0. We will push the node until queue 
 * becomes empty. Here we will use adjacency list to implement graph.
 */
public class BFS {

	int V;
	LinkedList<Integer> adj[];
	
	public BFS(int v) {
		adj = new LinkedList[v];
		V=v;
		for(int i=0;i<v;i++) 
			adj[i] = new LinkedList();
	}
	
	void addEdge(int v,int w) {
		adj[v].add(w);
	}
	
	
	void bfs(int s) {
		//Mark all vertices as non visited, by default it's false.
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<>();
		
		visited[s] = true;
		queue.add(s);
		while(!queue.isEmpty()) {
			s = queue.poll();
			System.out.print(s+ " ");
			
			Iterator<Integer> it = adj[s].iterator();
			while(it.hasNext()) {
				int n = it.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
			
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		BFS graph = new BFS(4);
		graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.bfs(2);
        
	}

}
