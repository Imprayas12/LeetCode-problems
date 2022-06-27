class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp1,1);
        for(int i = 0; i < nums.length ; i++){
            for(int prev = 0; prev < i; prev++){
                if(nums[prev] < nums[i] && 1 + dp1[prev] > dp1[i])
                    dp1[i] = 1 + dp1[prev];
            }
        }
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2,1);
        for(int i = nums.length - 1; i >= 0; i--){
            for(int prev = nums.length - 1; prev >= i; prev--){
                 if(nums[prev] < nums[i] && 1 + dp2[prev] > dp2[i])
                    dp2[i] = 1 + dp2[prev];
            }
        }
        int max = 0;
        for(int i = 0; i< nums.length; i++){
            if(dp1[i]>1 && dp2[i]>1)   
				max = Math.max(max, dp1[i] + dp2[i] - 1);
        }
        return nums.length - max;
    }
}