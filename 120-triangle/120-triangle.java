class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int[][] dp = new int[n][m];
        return minPath(triangle,0,0,dp);
    }
    private int minPath(List<List<Integer>> arr,int k,int l,int[][] dp){
        int n = arr.size()-1;
        for(int i=0;i<arr.get(n).size();i++){
            dp[n][i]=arr.get(n).get(i);
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i;j>=0;j--){
            int down = arr.get(i).get(j) + dp[i+1][j];
            int down_right = arr.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down,down_right);
            }
        }
        return dp[0][0];
    }
}