class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int[] dp1 = new int[nums.length-1];
        int[] dp2 = new int[nums.length-1];
        for(int i=0;i<n;i++){
            if(i!=0) dp1[i-1] = nums[i];
            if(i!=n-1) dp2[i] = nums[i];
        }
        return Math.max(getMaxAmount(dp1),getMaxAmount(dp2));
    }
    private int getMaxAmount(int[] arr){
        int n = arr.length;
        int prev = arr[0];
        int prev2 = 0;
        int max = 0;
        for(int i=1;i<n;i++){
            int take = arr[i];
            int not_take = -1;
            if(i>1) take += prev2;
                not_take = prev;
            max = Math.max(take,not_take);
            prev2 = prev;
            prev = max;
        }
        return max;
    }
}