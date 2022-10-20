class Solution {
    public int totalNQueens(int n) {
        return placeQueens(n,new char[n][n],0);
    }
    private int placeQueens(int N,char[][] ans,int r) {
        if(r == N) {
            return 1;
        }
        int s = 0;
        for(int j = 0; j < N; j++) {
            if(isSafe(ans,r,j)) {
                ans[r][j] = 'Q';
               s += placeQueens(N, ans, r + 1);
                ans[r][j] = '.';
            }
        }
        return s;
    }
    private boolean isSafe(char[][] ans,int r,int c) {
        //Check in left
        for(int i = c; i >= 0; i--) {
            if(ans[r][i] == 'Q') return false;
        }
        //Check in right
        for(int i = c; i < ans.length; i++) {
            if(ans[r][i] == 'Q') return false;
        }
        //Check down
        for(int i = r; i < ans.length; i++) {
            if(ans[i][c] == 'Q') return false;
        }
        //Check Up
        for(int i = r; i >= 0; i--) {
            if(ans[i][c] == 'Q') return false;
        }
        //Check up-left
        for(int i = r,j = c; i >= 0 && j >= 0; i--,j--) {
            if(ans[i][j] == 'Q') return false;
        }
        //Check up-right
        for(int i = r,j = c; i >= 0 && j < ans.length; i--,j++) {
            if(ans[i][j] == 'Q') return false;
        }
        //Check bottom-left
        for(int i = r,j = c; i < ans.length && j >= 0; i++,j--) {
            if(ans[i][j] == 'Q') return false;
        }
        //Check bottom-right
        for(int i = r,j = c; i < ans.length && j < ans.length; i++,j++) {
            if(ans[i][j] == 'Q') return false;
        }
        return true;
    }
}