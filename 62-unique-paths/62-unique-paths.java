class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return countWays(m-1,n-1,dp,m,n);
    }
    int countWays(int row,int col,int[][] dp,int m,int n){
        dp[0][0] = 1;
        
        for(row=0;row<m;row++){
            for(col=0;col<n;col++){
            if(row==0 && col==0){
              dp[0][0]=1; 
                continue;
            }  
            int down = 0;
            int right = 0;
             if(row>0)   down = dp[row-1][col];
             if(col>0)   right = dp[row][col-1];      
                dp[row][col] = down+right;    
            }
        }
        return dp[m-1][n-1];
    }
}