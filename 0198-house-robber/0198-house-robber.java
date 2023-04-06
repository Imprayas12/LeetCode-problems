class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        int n = nums.length;
        for(int i = 2; i < n; i++) {
            int chor = dp[i - 2] + nums[i];
            int notChor = dp[i - 1];
            dp[i] = Math.max(chor, notChor);
        }
        return dp[n - 1];
    }
}