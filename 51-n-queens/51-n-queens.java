class Solution {   
    public void saveBoard(char[][] board,List<List<String>> ans){
        String row= "";
        List<String> temp = new ArrayList<>();
        for(int i=0;i< board.length;i++){
            row="";
            for(int j=0;j< board[i].length;j++){
                if(board[i][j]=='Q')
                    row+='Q';
                else
                    row+='.';
            }
            temp.add(row);
        }
        ans.add(temp);
    }
    public boolean isSafe(char[][] board,int row,int col){
        for(int i=0;i<board.length;i++)
            if(board[row][i]=='Q') {
                return false;
            }
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        int r = row;
        for(int c=col;r>=0 && c>=0 ;r--,c--){
            if(board[r][c]=='Q')
                return false;
        }
        r=row;
        for(int c=col;c< board.length && r>=0;c++,r--){
            if(board[r][c]=='Q')
                return false;
        }
        r = row;
        for(int c=col;r< board.length && c>=0;r++,c--){
            if(board[r][c]=='Q')
                return false;
        }
        r=row;
        for(int c=col;c< board.length && r< board.length;r++,c++){
            if(board[r][c]=='Q')
                return false;
        }
        return true;
    }
    public void solveNQUtil(char[][] board,List<List<String>> ans,int col){
        if(col==board.length){
            saveBoard(board,ans);
        }
        for(int i=0;i< board.length;i++){
            if(isSafe(board,i,col)){
                board[i][col]='Q';
                solveNQUtil(board,ans,col+1);
                board[i][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        solveNQUtil(board,ans,0);
        return ans;
    }
}