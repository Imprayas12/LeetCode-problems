class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(var i: dp) for(var j: i) Arrays.fill(j,-1);
        return max(0,1,prices,2,dp);
    }
     private int max(int ind,int canBuy,int[] prices,int transaction,int[][][] dp){
        if(ind == prices.length)
            return 0;
        if(transaction == 0)
            return 0;
        if(dp[ind][canBuy][transaction] != -1) return dp[ind][canBuy][transaction]; 
        int profit = 0;
        if(canBuy == 1){
            profit = Math.max(-prices[ind]+max(ind+1,0,prices,transaction,dp),0+max(ind+1,1,prices,transaction,dp));
        }
        else{
            profit = Math.max(prices[ind]+max(ind+1,1,prices,transaction-1,dp),max(ind+1,0,prices,transaction,dp));
        }
        return dp[ind][canBuy][transaction] = profit;
    }
}