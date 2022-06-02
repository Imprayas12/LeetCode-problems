// { Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int[][] ans = ob.ShortestDistance(matrix);
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
    public int[][] ShortestDistance(int[][] matrix)
    {
        // Code here
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(var i: dp) Arrays.fill(i,-1);
        if(solve(matrix,0,0,dp)){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(dp[i][j]==-1)
                        dp[i][j]=0;
                }
            }
             return dp;
        }
        return new int[][]{{-1}};
    }
    private boolean solve(int[][] matrix,int i,int j,int[][] dp){
        int n = matrix.length;
        int m = matrix[0].length;
        if(i<0 || i>=n || j<0 || j>=n) return false;
        if(i== n-1 && j== m-1){
            dp[i][j] = 1; return true;
        }
        if(dp[i][j]!=-1) return false;
        for(int k=1;k<=matrix[i][j];k++) if(solve(matrix,i,j+k,dp) || solve(matrix,i+k,j,dp)){
            dp[i][j] = 1;
            return true;
        }
        dp[i][j] = 0;
        return false;
    }
}