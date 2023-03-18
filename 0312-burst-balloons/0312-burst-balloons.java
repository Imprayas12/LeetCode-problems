class Solution {
    public int maxCoins(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        int[] nums2 = new int[nums.length + 2];
        
        for(int i = 0; i < nums.length; i++) nums2[i + 1] = nums[i];
        
        nums2[0] = nums2[nums.length + 1] = 1;
        
        for(int[] row : dp) Arrays.fill(row, - 1);
        
        return mcm(nums2, 0, nums2.length - 1, dp);
    }
    private int mcm(int[] nums,int start, int end, int[][] dp) { 
        if(start + 1 == end) return 0;
        
        if(dp[start][end] != -1) return dp[start][end];
        
        int ans = 0;
        
        for(int i = start + 1; i < end; ++i) {
            int temp = mcm(nums, start, i, dp) + mcm(nums, i, end,dp) 
                + nums[start] * nums[i] * nums[end];       
            ans = Math.max(temp, ans);
        }
        return dp[start][end] = ans;
    }
}