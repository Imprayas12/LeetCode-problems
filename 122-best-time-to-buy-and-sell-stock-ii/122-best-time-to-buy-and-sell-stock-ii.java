class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
       for(var i: dp) Arrays.fill(i,Integer.MIN_VALUE);
        return max(0,1,prices,dp);
    }
    private int max(int ind,int canBuy,int[] prices,int[][] dp){
        if(ind == prices.length)
            return 0;
        if(dp[ind][canBuy]!= Integer.MIN_VALUE) return dp[ind][canBuy];
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