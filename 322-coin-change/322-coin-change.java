class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==1)
            return amount%coins[0]==0?amount/coins[0]:-1;
        int[][] dp = new int[coins.length][amount+1];
        for(int[] i:dp)
            Arrays.fill(i,999999);
        int ans = coinCount(coins.length-1,coins,amount,dp);
        return ans==9999999?-1:ans;
    }
    private int coinCount(int ind,int[] coins,int amt,int[][] dp){
        if(ind==0){
            if(amt%coins[ind]==0) return amt/coins[ind];
            return 9999999;
        }
        if(dp[ind][amt]!=999999) return dp[ind][amt];
        int notTake = coinCount(ind-1,coins,amt,dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind]<=amt) take = 1+ coinCount(ind,coins,amt-coins[ind],dp);
        return dp[ind][amt]=Math.min(take,notTake);
    }
}