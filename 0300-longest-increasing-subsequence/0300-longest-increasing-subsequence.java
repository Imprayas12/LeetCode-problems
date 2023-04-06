class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(var i: dp) Arrays.fill(i,-1);
        return max(0,-1,nums,dp);   
    }
    private int max(int ind,int prev,int[] nums,int[][] dp){
        if(ind == nums.length)
            return 0;
        int pick = 0;
        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];
        if(prev == -1)
            pick = 1 + max(ind+1,ind,nums,dp);
        else if(nums[ind]>nums[prev])
        pick = 1 + max(ind+1,ind,nums,dp);
        int not_pick = max(ind+1,prev,nums,dp);
        return dp[ind][prev+1] = Math.max(pick,not_pick);
    }
}