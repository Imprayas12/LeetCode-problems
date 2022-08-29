class Solution {
    class Pair {
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    bfs(i,j,vis,grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    private void bfs(int row,int col, int[][] vis, char[][] grid) {
        vis[row][col] = 1;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(row,col));
        int m = grid.length;
        int n = grid[0].length;
        while(!queue.isEmpty()) {
            int r = queue.peek().x;
            int c = queue.peek().y;
            queue.poll();
            for(int dr = -1; dr <= 1; dr++){
                for(int dc = -1; dc <= 1; dc++){
                    
                      if((dr == -1 && dc == -1) || (dr == -1 && dc == 1) || (dr == 1 && dc == -1) || (dr == 1 && dc == 1)){
                        continue;
                    }
                    int rowC = r + dr;
                    int colD = c + dc;
                    if(rowC >= 0 && rowC < m && colD >= 0 && colD < n && grid[rowC][colD] == '1' && vis[rowC][colD] != 1){
                        bfs(rowC,colD,vis,grid);
                    }
                }
            }
        }
    }
}