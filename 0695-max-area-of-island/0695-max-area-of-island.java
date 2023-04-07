class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1)
                ans = Math.max(dfs(grid,i,j),ans);
            }
        }
        return ans;
    }
    private int dfs(int[][] grid, int x, int y) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length ||  grid[x][y] == 0) return 0;
        grid[x][y] = 0;
        int left = dfs(grid,x,y - 1);
        int right = dfs(grid,x,y + 1);
        int up = dfs(grid,x - 1, y);
        int down = dfs(grid, x + 1, y);
        return 1 + left + right + up + down;
    }
}