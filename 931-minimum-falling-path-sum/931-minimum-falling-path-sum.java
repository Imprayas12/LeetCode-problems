class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            ans = Math.min(ans,minPath(0,i,matrix,dp));
        }
        return ans;
    }
    private int minPath(int i,int j,int[][] arr,int[][] dp){
        if(i==arr.length-1)
            return arr[i][j];
        if(dp[i][j]!=0) return dp[i][j];
        int left = Integer.MAX_VALUE;
        int bottom = Integer.MAX_VALUE; 
        int right = Integer.MAX_VALUE; 
        if(j>0) left = arr[i][j]+ minPath(i+1,j-1,arr,dp);
        bottom = arr[i][j] + minPath(i+1,j,arr,dp);
        if(j<arr.length-1) right = arr[i][j] + minPath(i+1,j+1,arr,dp);
        return dp[i][j] = Math.min(right,Math.min(left,bottom));
    }
}