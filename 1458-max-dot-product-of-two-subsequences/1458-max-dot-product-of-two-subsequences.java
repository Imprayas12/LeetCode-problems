class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(var i: dp) Arrays.fill(i, Integer.MIN_VALUE);
        int ans = helper(nums1, nums2, 0, 0,false, dp);
        return ans == -999999 ? -1 : ans;
    }
    private int helper(int[] nums1, int[] nums2, int i, int j,boolean flag, int[][] dp) {
        if(i == nums1.length || j == nums2.length) {
            if(flag) return 0;
            else return -999999;
        }
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        int take = helper(nums1, nums2, i + 1, j + 1,true, dp);
        int t = nums1[i] * nums2[j] + take;
        int notTake = Math.max(helper(nums1, nums2, i + 1, j,false, dp), helper(nums1, nums2, i, j + 1, false, dp));
        return dp[i][j] = Math.max(nums1[i] * nums2[j], Math.max(t, notTake));
    }
}