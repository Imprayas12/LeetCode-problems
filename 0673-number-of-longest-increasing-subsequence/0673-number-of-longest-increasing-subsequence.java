class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        int maxi = 0;
        for(int i = 0; i < n; i++){
            for(int prev = 0; prev <= i; prev++){
                if(nums[prev] < nums[i] && 1 + dp[prev] > dp[i])
                {
                    dp[i] = dp[prev] + 1;
                    cnt[i] = cnt[prev];
                } else if(nums[prev] < nums[i] && 1 + dp[prev] == dp[i])
                    cnt[i] += cnt[prev];
            }
            maxi = Math.max(dp[i],maxi);
        }
        int ans = 0;
        for(int i = 0; i< n;i++){
            if (dp[i] == maxi) ans+= cnt[i];
        }
        return ans;
    }
}