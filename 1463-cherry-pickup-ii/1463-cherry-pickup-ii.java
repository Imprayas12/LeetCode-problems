class Solution {
    public int cherryPickup(int[][] grid) {
        int di[] = {-1,0,1};
        int[] dj = {-1,0,1};
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        return maxCherry(grid,di,dj,dp);
    }
    private int maxCherry(int[][] grid,int[] di,int[] dj,int[][][] dp){
        int n = grid.length;
        for(int k=0;k<dp[0].length;k++){
            for(int l=0;l<dp[0].length;l++){
                if(k==l)
                dp[n-1][k][l]=grid[n-1][k];
                else
                dp[n-1][k][l]=grid[n-1][k]+grid[n-1][l];
            }
        }
        int m = grid[0].length;
        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int ansi = Integer.MIN_VALUE;
                    for(int k:di){
                        for(int l:dj){
                            int ans=0;
                            if(j1==j2)
                                ans = grid[i][j1];
                            else ans = grid[i][j1]+grid[i][j2];
                            if(j1+k>=0 && j2+l>=0 && j1+k<m && j2+l<m){
                            ans += dp[i+1][j1+k][j2+l];
                                ansi = Math.max(ans,ansi);
                            }
                            else
                            ans += -100000000;
                        }
                    }
                    dp[i][j1][j2]= ansi;
                }
            }
        }
        return dp[0][0][m-1];
    }
}