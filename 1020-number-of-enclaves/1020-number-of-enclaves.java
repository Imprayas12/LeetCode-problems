class Solution {
    class Pair {
        int x;
        int y;
        Pair(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int numEnclaves(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid[0].length; i++) {
            if(grid[0][i] == 1) {
                vis[0][i] = true;
                queue.add(new Pair(0,i));
            }
            if(grid[grid.length - 1][i] == 1) {
                vis[grid.length - 1][i] = true;
                queue.add(new Pair(grid.length - 1,i));
            }
        }
        for(int i = 0; i < grid.length; i++) {
            if(grid[i][0] == 1) {
                vis[i][0] = true;
                queue.add(new Pair(i,0));
            }
            if(grid[i][grid[0].length - 1] == 1) {
                vis[i][grid[0].length - 1] = true;
                queue.add(new Pair(i, grid[0].length - 1));
            }
        }
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        while(!queue.isEmpty()) {
            int x = queue.peek().x;
            int y = queue.peek().y;
            queue.remove();
            for(int i = 0; i < 4; i++) {
                int nrow = x + dx[i];
                int ncol = y + dy[i];
                if(isValid(nrow,ncol,vis) && grid[nrow][ncol] == 1) {
                    vis[nrow][ncol] = true;
                    queue.add(new Pair(nrow,ncol));
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) ans++;
            }
        }
        return ans;
    }
    private boolean isValid(int x,int y,boolean[][] vis) {
        return x >= 0 && y >= 0 && x < vis.length && y < vis[0].length && !vis[x][y];
    }
}