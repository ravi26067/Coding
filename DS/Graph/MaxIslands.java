class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = 0;
        if(m!=0){
            n = grid[0].length;
        }
        int res = 0;
        int tmp = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                tmp=0;
                if(grid[i][j]==1){
                    tmp = BFS(i,j,grid,m,n);
                    res = Math.max(res,tmp);
                    //System.out.println("i: " + i + " j:" + j + " val: " + tmp);
                }
            }
        }
        return res;
    }

    class Pair{
        int first;
        int second;

        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }

    int BFS(int x,int y,int grid[][],int m,int n){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x,y));
        grid[x][y] = 0;
        int count  = 0;
        while (!queue.isEmpty()){
            Pair pr = queue.remove();
            int a = pr.first;
            int b = pr.second;
            count++;

            if(a+1 < m && grid[a+1][b]==1){
                grid[a+1][b] = 0;
                queue.add(new Pair(a+1,b));
            }
            if(a-1>=0 && grid[a-1][b]==1){
                grid[a-1][b] = 0;
                queue.add(new Pair(a-1,b));
            }
            if(b+1<n && grid[a][b+1]==1){
                grid[a][b+1] = 0;
                queue.add(new Pair(a,b+1));
            }
            if(b-1>=0 && grid[a][b-1]==1){
                grid[a][b-1] = 0;
                queue.add(new Pair(a,b-1));
            }
        }
        return count;
    }
}
