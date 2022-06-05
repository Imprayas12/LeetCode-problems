class Solution {
    public int minPathSum(int[][] grid) {
        int i = grid.length;
        int j = grid[0].length;
        int[][] dp = new int[i][j];
        return minPath(grid,i-1,j-1,dp);
    }
    private int minPath(int[][] a,int i,int j,int[][] dp){
        if(i==0 && j==0) return a[i][j];
        if(dp[i][j]!=0) return dp[i][j];
        if(i==0) return dp[i][j]=a[i][j]+ minPath(a,i,j-1,dp);
        if(j==0) return dp[i][j]=a[i][j]+ minPath(a,i-1,j,dp);
        int up = a[i][j] + minPath(a,i-1,j,dp);
        int left = a[i][j] + minPath(a,i,j-1,dp);
        return dp[i][j]=Math.min(up,left);
    }
}