class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) for(int k=0;k<n;k++)
            dp[i][j][k] = Integer.MIN_VALUE;
     return Math.max(0,cherryCount(grid,0,0,0,grid.length,dp));   
    }
    private int cherryCount(int[][] grid,int i,int j1,int j2,int n,int[][][] dp){
        int i2 = i + j1-j2;
        if(i==n || i2==n || j1==n || j2==n || grid[i][j1]==-1 || grid[i2][j2]==-1 ) return Integer.MIN_VALUE;
        else if(i==n-1 && j1==n-1) return grid[i][j1];
        else if(dp[i][j1][j2]!= Integer.MIN_VALUE) return dp[i][j1][j2];
        else {
        int ans = grid[i][j1];
        if(j1!=j2) ans+= grid[i2][j2];
        ans += Math.max(Math.max(cherryCount(grid,i,j1+1,j2+1,n,dp),cherryCount(grid,i+1,j1,j2+1,n,dp)), Math.max(cherryCount(grid,i,j1+1,j2,n,dp),cherryCount(grid,i+1,j1,j2,n,dp)));
        return dp[i][j1][j2]=ans;
             }
    }
}