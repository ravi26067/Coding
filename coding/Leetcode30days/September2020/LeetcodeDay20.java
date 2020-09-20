class Solution {
    public int uniquePathsIII(int[][] g) {
        int x = 0, y = 0, empty = 0;
        for(int i=0; i < g.length; i++)
            for(int j=0; j < g[0].length; j++)
                if(g[i][j] == 0)
                    ++empty;
                else if(g[i][j] == 1){
                    x = i;
                    y = j;
                }

        return dfs(g, x, y, -1, empty);
    }
    private int dfs(int[][] g, int i, int j, int count, int need){
        if(i < 0 || i == g.length || j < 0 || j == g[0].length || g[i][j] == -1) return 0;
        if(g[i][j] == 2){
            if(count == need)
                return 1;
            else
                return 0;
        }
        g[i][j] = -1;
        int total = dfs(g, i-1, j, count+1, need);
        total += dfs(g, i, j+1, count+1, need);
        total += dfs(g, i+1, j, count+1, need);
        total += dfs(g, i, j-1, count+1, need);
        g[i][j] = 0;
        return total;
    }
}
