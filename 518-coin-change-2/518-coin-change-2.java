class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] i: dp) Arrays.fill(i,-1);
        return count(coins.length - 1,amount,coins,dp);
    }
    private int count(int ind,int amt,int[] coins,int[][] dp){
        if(amt == 0) return 1;
        if(ind < 0) return 0;
        if(dp[ind][amt] != -1) return dp[ind][amt];
        int notTake = count(ind - 1, amt, coins,dp);
        int take = 0;
        if(coins[ind] <= amt) take = count(ind,amt - coins[ind],coins,dp);
        return dp[ind][amt] = take + notTake;
    }
}