class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        return helperTB(nums1, nums2);
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
    private int helperTB(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int spesal = Integer.MIN_VALUE;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                spesal = Math.max(nums1[i - 1] * nums2[j - 1], spesal);
                int take = nums1[i - 1] * nums2[j - 1] + dp[i - 1][j - 1];
                int notTake = Math.max(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = Math.max(nums1[i - 1] * nums2[j - 1], Math.max(take, notTake));
            }
        }
        return dp[dp.length - 1][dp[0].length - 1] == 0 ? spesal : dp[dp.length - 1][dp[0].length - 1];
    }
}