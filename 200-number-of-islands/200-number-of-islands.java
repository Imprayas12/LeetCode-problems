class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // int[][] vis = new int[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    bfs(i,j,grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    private void bfs(int i,int j,char[][] grid) {
        if(i >= 0 && i < grid.length && j >=0 && j < grid[0].length && grid[i][j] != '0'){
            grid[i][j] = '0';
            bfs(i - 1, j, grid);
            bfs(i ,j - 1, grid);
            bfs(i + 1, j, grid);
            bfs(i, j + 1, grid);
        }
    }
}