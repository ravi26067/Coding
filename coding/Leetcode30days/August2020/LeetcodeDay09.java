class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int M = grid.length;
        int N = grid[0].length;
        boolean already = true;
        while(true){
            boolean hasFresh = false;
            HashSet<Pair<Integer, Integer>> set = new HashSet<>(); 
            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    if(grid[i][j] != 1) continue;
                    already = false;
                    boolean up = (i == 0) ? false : (grid[i - 1][j] == 2);
                    boolean down = (i == M - 1) ? false : (grid[i + 1][j] == 2);
                    boolean left = (j == 0) ? false : (grid[i][j - 1] == 2);
                    boolean right = (j == N - 1) ? false : (grid[i][j + 1] == 2);
                    if(up || down || left || right)
                        set.add(new Pair(i, j));
                    else
                        hasFresh = true;
                }
            }
            if(already) return 0;
            if(set.size() == 0 && hasFresh)
                return -1;
            for(Pair<Integer, Integer> pair : set){
                int i = pair.getKey();
                int j = pair.getValue();
                grid[i][j] = 2;
            }
            time++;
            if(!hasFresh)
                break;
        }
        return time;
    }
