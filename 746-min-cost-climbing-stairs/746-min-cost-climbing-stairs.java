class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==0) return 0;
        if(cost.length==1) return cost[0];
        int[] dp = new int[cost.length];
        dp[0]=0;
        dp[1]=0;
        int n = cost.length;
        for(int i=2;i<cost.length;i++){
            dp[i]=Math.min(cost[i-1]+dp[i-1],cost[i-2]+dp[i-2]);
        }
        return Math.min(cost[n-1]+dp[n-1],cost[n-2]+dp[n-2]);
    }
}