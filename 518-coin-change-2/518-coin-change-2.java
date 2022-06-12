class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<=amount;i++){
           if(i % coins[0] == 0) dp[0][i] = 1;
        }
        for(int ind = 1;ind < coins.length;ind++){
            for(int amt = 0;amt <= amount; amt++){
                int notTake = dp[ind-1][amt];
                int take = 0;
                if(coins[ind]<=amt) take = dp[ind][amt-coins[ind]];
                dp[ind][amt] = take + notTake;
            }
        }
        return dp[coins.length-1][amount];
    }
}