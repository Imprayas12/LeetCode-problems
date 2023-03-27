class Solution {
    public int minPathSum(int[][] grid) {
        int i = grid.length;
        int j = grid[0].length;
        int[][] dp = new int[i][j];
        return minPath(grid,i-1,j-1,dp);
    }
    private int minPath(int[][] a,int m,int n,int[][] dp){ 
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j==0) dp[i][j] = a[i][j];
                else if(i==0) dp[i][j] = a[i][j]+dp[i][j-1];
                else if(j==0) dp[i][j] = a[i][j]+dp[i-1][j];
                else{
                    int up=0,left=0;
                    up = a[i][j] + dp[i-1][j];
                    left = a[i][j]+ dp[i][j-1];
                    dp[i][j]=Math.min(up,left);
                }
            }
        }
        return dp[m][n];
    }
}