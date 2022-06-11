class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==1)
            return amount%coins[0]==0?amount/coins[0]:-1;
        int[][] dp = new int[coins.length][amount+1];
       for(int i=0;i<=amount;i++){
           if(i%coins[0]==0)
               dp[0][i]=i/coins[0];
           else
               dp[0][i]=999999;
       }
        for(int ind=1;ind<coins.length;ind++){
            for(int amt=0;amt<=amount;amt++){
             int notTake = dp[ind-1][amt];
            int take = Integer.MAX_VALUE;
            if(coins[ind]<=amt) take = 1+ dp[ind][amt-coins[ind]];   
            dp[ind][amt]=Math.min(take,notTake);
            }
        }
        return dp[coins.length-1][amount]==999999?-1:dp[coins.length-1][amount];
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