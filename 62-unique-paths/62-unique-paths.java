class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return countWays(m-1,n-1,dp);
    }
    int countWays(int row,int col,int[][] dp){
        if(row==0 && col==0){
            return 1;
        }
        if(row<0 || col<0)
            return 0;
        if(dp[row][col]!=0) return dp[row][col];
        int up = countWays(row-1,col,dp);
        int left = countWays(row,col-1,dp);
        return dp[row][col] = up + left;
    }
}