class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean visited[] = new boolean[n];
        
        ans.add(0);
        dfs(graph, 0, n-1, ans, res, visited);
        return res;
    }
    
    private void dfs(int[][] graph, int source, int target, List<Integer> ans, List<List<Integer>> res, boolean[] visited){
        if(source == target){
            res.add(ans);
            return;
        }
        
        for(int i = 0; i < graph[source].length; i++){
            if(!visited[graph[source][i]]){
                List<Integer> list = new ArrayList<>(ans);
                list.add(graph[source][i]);
                visited[graph[source][i]] = true;
                dfs(graph, graph[source][i], target, list, res, visited);
                visited[graph[source][i]] = false;
            }
        }
    }
}
