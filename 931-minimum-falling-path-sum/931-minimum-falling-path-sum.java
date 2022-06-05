class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        return minPath(matrix,dp);
    }
    private int minPath(int[][] arr,int[][] dp){
        int n = arr.length;
        for(int k=0;k<n;k++){
            dp[n-1][k] = arr[n-1][k];
        }
        for(int k=n-2;k>=0;k--){
            for(int l=n-1;l>=0;l--){
            int left = Integer.MAX_VALUE;
            int bottom = Integer.MAX_VALUE; 
            int right = Integer.MAX_VALUE; 
            if(l>0)
                left = arr[k][l]+ dp[k+1][l-1];
                bottom = arr[k][l] + dp[k+1][l]; 
            if(l<arr.length-1)    
                right = arr[k][l] + dp[k+1][l+1];
                dp[k][l] = Math.min(right,Math.min(left,bottom));        
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int k=0;k<n;k++){
            ans = Math.min(ans,dp[0][k]);
        }
        return ans;
    }
}