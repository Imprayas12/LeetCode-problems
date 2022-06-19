class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(var i: dp) Arrays.fill(i, -1);
        return maxP(0,1,fee,prices,dp);
    }
    private int maxP(int ind,int canBuy,int fee,int[] prices,int[][] dp){
        if(ind == prices.length)
            return 0;
        if(dp[ind][canBuy]!=-1) return dp[ind][canBuy];
        int profit = 0;
        if(canBuy==1){
            profit = Math.max(-prices[ind]+maxP(ind+1,0,fee,prices,dp),maxP(ind+1,1,fee,prices,dp));
        }
        else {
            profit = Math.max(prices[ind]-fee + maxP(ind+1,1,fee,prices,dp),maxP(ind+1,0,fee,prices,dp));
        }
        return dp[ind][canBuy] = profit;
    }
}