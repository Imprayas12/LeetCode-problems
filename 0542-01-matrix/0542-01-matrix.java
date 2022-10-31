class Solution {
    class Triplet {
        int x;
        int y;
        int dist;
        Triplet(int x,int y,int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dist = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Triplet> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new Triplet(i,j,0));
                    vis[i][j] = true;
                }
            }
        }
        int[] dx = {0,-1,0,1};
        int[] dy = {1,0,-1,0};
        while(!queue.isEmpty()) {
            int x = queue.peek().x;
            int y = queue.peek().y;
            int dt = queue.peek().dist;
            dist[x][y] = dt;
            queue.poll();
            for(int i = 0; i < 4; i++) {
                int nrow = x + dx[i];
                int ncol = y + dy[i];
                if(isValid(nrow,ncol,vis)){
                    vis[nrow][ncol] = true;
                    queue.add(new Triplet(nrow,ncol,dt + 1));
                }
            }
        }
        return dist;
    }
    private boolean isValid(int x,int y,boolean[][] vis) {
        return x >= 0 && y >= 0 && x < vis.length && y < vis[0].length && !vis[x][y];
    }
}