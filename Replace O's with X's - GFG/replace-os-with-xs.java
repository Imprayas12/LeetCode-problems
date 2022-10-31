//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char board[][])
    {
        // code here
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < m; i++) {
            //Checking top and bottom boundries
            if(board[0][i] == 'O' && !vis[0][i]) dfs(0,i,vis,board);
            if(board[n - 1][i] == 'O' && !vis[n - 1][i]) dfs(n-1,i,vis,board);
        }
        for(int i = 0; i < n; i++) {
            //Checking left and right boundries
            if(board[i][0] == 'O' && !vis[i][0]) dfs(i,0,vis,board);
            if(board[i][m - 1] == 'O' && !vis[i][m - 1]) dfs(i,m - 1,vis,board);
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j]) board[i][j] ='X';
            }
        }
        return board;
    }
    private static void dfs(int x,int y,boolean[][] vis,char[][] board) {
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
    private static boolean isValid(int x,int y,boolean[][] vis) {
        return x >= 0 && y >= 0 && x < vis.length && y < vis[0].length && !vis[x][y];
    }
}