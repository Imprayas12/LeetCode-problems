class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        dp[prices.length][0] = dp[prices.length][1] = 0;
        for(int i = prices.length-1;i>=0;i--){
            for(int buy = 0;buy<=1;buy++){
                int profit = 0;
                if(buy == 1)
                    profit = Math.max(-prices[i] + dp[i+1][0],dp[i+1][1]);
                else
                    profit = Math.max(prices[i] + dp[i+1][1],dp[i+1][0]);
                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
    }
    private int max(int ind,int canBuy,int[] prices,int[][] dp){
        if(ind == prices.length)
            return 0;
        if(dp[ind][canBuy] != Integer.MIN_VALUE) return dp[ind][canBuy];
        int profit = 0;
        if(canBuy==1){
            profit = Math.max(-prices[ind]+max(ind+1,0,prices,dp),0+max(ind+1,1,prices,dp));
        }
        else{
            profit = Math.max(prices[ind]+max(ind+1,1,prices,dp),max(ind+1,0,prices,dp));
        }
        return dp[ind][canBuy] = profit;
    }
}