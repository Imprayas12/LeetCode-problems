class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) dp[i][j]=-1;
        return minPath(triangle,0,0,dp);
    }
    private int minPath(List<List<Integer>> arr,int i,int j,int[][] dp){
        if(i==arr.size()-1) return arr.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        int down = arr.get(i).get(j) + minPath(arr,i+1,j,dp);
        int down_right = arr.get(i).get(j) + minPath(arr,i+1,j+1,dp);
        
        return dp[i][j]=Math.min(down,down_right);
    }
}