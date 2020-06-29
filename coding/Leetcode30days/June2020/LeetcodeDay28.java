import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Here we are using Eulerian path, it is a trail in a finite graph that visits
 * every edge exactly once. We have starting position fixed. 
 * We are creating graph using map and priority queue in which 
 */
public class Solution {

	Map<String, PriorityQueue<String>> map;
	LinkedList<String> result;

	public List<String> findItinerary(List<List<String>> tickets) {
		map = new HashMap<String, PriorityQueue<String>>();
		result = new LinkedList<String>();

		// create the graph using map of string and priority queue
		for (List<String> ticket : tickets) {
			String from = ticket.get(0), to = ticket.get(1);

			if (!map.containsKey(from))
				map.put(from, new PriorityQueue<String>());

			map.get(from).offer(to);
		}

		dfs("JFK");

		return result;
	}

	private void dfs(String from) {
		PriorityQueue<String> arrival = map.get(from);

		while (arrival != null && !arrival.isEmpty())
			dfs(arrival.poll());

		result.addFirst(from);

	}
}