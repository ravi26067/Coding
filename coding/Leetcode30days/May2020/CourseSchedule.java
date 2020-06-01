import java.util.ArrayList;
import java.util.List;

/**
 * @author ravik 
 * Here we are doing BFS traversal. We have three states, unvisited denoted by 0, visited is denoted by 1 and completed is represented by 2.
 * We are checking if any node has neighbour with visited flag as 1 then we will return false else we will continue with other neighbour.
 */
public class CourseSchedule {

	private boolean dfs(List<Integer>[] graph, int visited[], int v) {

		if (visited[v] == 1)
			return false;

		visited[v] = 1;

		for (int gr : graph[v])
			if (!dfs(graph, visited, gr))
				return false;

		visited[v] = 2;

		return true;
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			graph[i] = new ArrayList<Integer>();

		int visited[] = new int[numCourses];

		for (int[] pre : prerequisites) {
			graph[pre[0]].add(pre[1]);
		}

		for (int i = 0; i < numCourses; i++)
			if (visited[i] == 0 && !dfs(graph, visited, i))
				return false;

		return true;
	}

	public static void main(String[] args) {
		CourseSchedule crs = new CourseSchedule();
		int N = 2;
		int arr[][] = { { 0, 1 } };
		System.out.println(crs.canFinish(N, arr));
		;

	}

}
