class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int[][] dp = new int[n][n + 1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return findMax(satisfaction, 1,0,dp);
    }
    private int findMax(int[] arr, int time, int idx,int[][] dp) {
        if(idx == arr.length) return 0;
        if(dp[idx][time] != -1) return dp[idx][time];
        return dp[idx][time] = Math.max(arr[idx] * time + findMax(arr, time + 1, idx + 1,dp), findMax(arr, time, idx + 1,dp));      
    }
}