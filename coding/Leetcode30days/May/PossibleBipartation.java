import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ravik
 * In this video we are using the BFS approach. Here we will take a graph(adjacancy matrix) where we will store the all numbers which are dislike of i th position 
 * at graph[i]. We will use one queue so that we will start coloring the color array.
 */
public class PossibleBipartation {

	public boolean possibleBipartition(int N, int[][] dislikes) {
		
		int colors[]= new int[N+1];
		List<Integer> graph[] = new List[N+1];
		
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int [] v : dislikes) {
			graph[v[0]].add(v[1]);
			graph[v[1]].add(v[0]);
		}
		
		for(int i=1;i<=N;i++) {
			if(colors[i]==0) {
				LinkedList<Integer> queue = new LinkedList<Integer>();
				colors[i] = 1;
				queue.add(i);
				while(queue.size()!=0) {
					int top = queue.removeFirst();
					for(int neighbour:graph[top]) {
						if(colors[neighbour]== colors[top])
							return false;
						if(colors[neighbour]==0) {
							colors[neighbour] = -colors[top];
							queue.add(neighbour);
						}
					}
				}
			}
		}
		
		
        return true;
    }

	public static void main(String[] args) {
		PossibleBipartation bp = new PossibleBipartation();
		int N =4;
		int A[][] = { {1, 2}, {1, 3}, {2, 4}};
		System.out.println(bp.possibleBipartition(N, A));
	}
}
