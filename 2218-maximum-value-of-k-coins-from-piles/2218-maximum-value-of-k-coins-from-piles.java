class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
     /*
     -> Pick the first coin from the pile and move to next.
     -> Don't pick the first coin from pile and move to next.
     -> Pick first coin and stay on the same pile to pick the next coin.
     */   
        int[][] dp = new int[piles.size()][k + 1];
        for(var i:dp) Arrays.fill(i,-1);
        return move(piles,k,0,dp);
    }
    private int move(List<List<Integer>> piles, int k, int pileInd,int[][] dp) {
        if(k == 0) return 0;
        if(pileInd == piles.size())
            return 0;
        if(dp[pileInd][k] != -1) return dp[pileInd][k];
        int dontPick = move(piles,k,pileInd + 1,dp);
        int s = 0;
        for(int i = 0; i < k && i < piles.get(pileInd).size(); i++) {
            s += piles.get(pileInd).get(i);
            dontPick = Math.max(dontPick,s + move(piles,k - (i + 1), pileInd + 1,dp));
        }
        // int dontPick = move(piles,k,pileInd + 1,sum,dp);
        return dp[pileInd][k] = dontPick;
    }
}