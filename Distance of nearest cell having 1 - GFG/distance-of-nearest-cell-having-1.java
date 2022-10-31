//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
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
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] mat)
    {
        // Code here
        int n = mat.length;
        int m = mat[0].length;
        int[][] dist = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Triplet> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 1) {
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