class Solution {
    int empty = 0;
    public int uniquePathsIII(int[][] grid) {
        int sx = 0,sy = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
                if(grid[i][j] == 0) ++empty;
            }
        }
        int ans = recur(grid,sx,sy);
        return ans;
    }
    private int recur(int[][] grid,int x,int y) {
        if(x >= grid.length || y >= grid[0].length || x < 0 || y < 0 || grid[x][y] < 0) return 0;
        if(grid[x][y] == 2) {
            return empty == 0 ? 1 : 0;
        }
        int ans = 0;
        int t = grid[x][y];
        grid[x][y] = -1;
        if(t == 0) empty--;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        for(int i = 0; i < 4; i++) {
            ans += recur(grid,x + dx[i],y + dy[i]);
        }
        grid[x][y] = t;
        if(t == 0) empty++;
        return ans;
    }
}