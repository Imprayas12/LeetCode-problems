class Solution {
    class Triplet {
        int row;
        int col;
        int time;
        Triplet(int row,int col,int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int maxTime = 0;
        Queue<Triplet> q = new LinkedList<>();
        int[][] vis = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Triplet(i,j,0));
                    vis[i][j] = 2;
                }
                else
                    vis[i][j] = 0;
            }
        }
        int[] dX = {0,0,-1,1};
        int[] dY = {-1,1,0,0};
        
        while(!q.isEmpty()) {
            int R = q.peek().row;
            int C = q.peek().col;
            int T = q.peek().time;
            q.poll();
            maxTime = Math.max(maxTime,T);
            for(int i = 0; i < 4; i++) {
                int curRow = R + dX[i];
                int curCol = C + dY[i];
                if(curRow >= 0 && curRow < grid.length && curCol >= 0 && curCol < grid[0].length && vis[curRow][curCol] == 0 && grid[curRow][curCol] == 1) {
                    vis[curRow][curCol] = 2;
                    q.add(new Triplet(curRow,curCol,T + 1));
                }
            }
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(vis[i][j] != 2 && grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return maxTime;
    }
}