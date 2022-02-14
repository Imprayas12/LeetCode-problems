class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];  // the minimum number of jumps from a position to the last position
        
        dp[n - 1] = 0;
        
        for (int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;    // the minimum number of jumps from position i to the last position
            
            for (int j = i + 1; j < n && j <= i + nums[i]; j++) {   // can jump from the position i to the position j
                if (dp[j] == Integer.MAX_VALUE) continue;           // cannot jump from the position j to the last position
                min = Math.min(dp[j] + 1, min);                     // dp[j] + 1 means jump from i to j and then jump to the last
            }
            
            dp[i] = min;
        }
        
        return dp[0];
    }
}