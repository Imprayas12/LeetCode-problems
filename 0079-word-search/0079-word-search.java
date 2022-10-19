class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0))
                ans = ans || check(board,word,i,j,new boolean[board.length][board[0].length],"",0);
            }
        } 
        return ans;
    }   
    private boolean check(char[][] board,String word,int x,int y,boolean[][] vis,String cur,int ind) {
        if(ind == word.length()) return true;
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || vis[x][y] || board[x][y] != word.charAt(ind)) return false;
        vis[x][y] = true;
        if(check(board,word,x + 1,y,vis,cur + board[x][y],ind + 1)) return true;
        if(check(board,word,x,y + 1,vis,cur + board[x][y],ind + 1)) return true;
        if(check(board,word,x - 1,y,vis,cur + board[x][y],ind + 1)) return true;
        if(check(board,word,x,y - 1,vis,cur + board[x][y],ind + 1)) return true;
        vis[x][y] = false;
        return false;
    }
}