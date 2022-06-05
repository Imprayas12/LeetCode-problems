class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        return countUnique(obstacleGrid,m-1,n-1,dp);
    }
    private int countUnique(int[][] arr,int m,int n,int[][] dp){
        if(m>=0 && n>=0 && arr[m][n]==1) return 0;
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;
        if(dp[m][n]!=0) return dp[m][n];
        int left = countUnique(arr,m,n-1,dp);
        int up = countUnique(arr,m-1,n,dp);
        return dp[m][n] = left + up;
    }
}