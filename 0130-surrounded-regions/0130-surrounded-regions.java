class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < m; i++) {
            if(board[0][i] == 'O' && !vis[0][i]) dfs(0,i,vis,board);
            if(board[n - 1][i] == 'O' && !vis[n - 1][i]) dfs(n-1,i,vis,board);
        }
        for(int i = 0; i < n; i++) {
            if(board[i][0] == 'O' && !vis[i][0]) dfs(i,0,vis,board);
            if(board[i][m - 1] == 'O' && !vis[i][m - 1]) dfs(i,m - 1,vis,board);
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j]) board[i][j] ='X';
            }
        }
    }
    private void dfs(int x,int y,boolean[][] vis,char[][] board) {
        if(!isValid(x,y,vis)) return;
        if(board[x][y] == 'O') {
            vis[x][y] = true;
        } 
        else return;
        int[] dx = {-1,0,+1,0};
        int[] dy = {0,-1,0,+1};
        for(int i = 0; i < 4; i++) {
            dfs(x + dx[i],y + dy[i],vis,board);
        }
    }
    private boolean isValid(int x,int y,boolean[][] vis) {
        return x >= 0 && y >= 0 && x < vis.length && y < vis[0].length && !vis[x][y];
    }
}