class Solution {
    public boolean canPartition(int[] nums) {
       int n =nums.length;
    int sum=0;
        for(var i:nums) sum+=i;
        if(sum%2==1) return false;
        boolean[][] dp = new boolean[n][sum/2+1];
        int k = sum/2;
        for(int i=0;i<n;i++) dp[i][0]= true;
        if(nums[0]<=k) dp[0][nums[0]]=true;
        for(int i=1;i<n;i++){
            for(int j=1;j<=k;j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(nums[i]<=j) take = dp[i-1][j-nums[i]];
                dp[i][j]=take||notTake;
            }
        }
        return dp[n-1][k];
    }
}