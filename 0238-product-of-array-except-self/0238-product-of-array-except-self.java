class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pref = new int[nums.length];
        pref[0] = nums[0];
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] * nums[i];
        }
        int[] suff = new int[n];
        suff[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i];
        }
        for(int i = 0; i < n; i++) {
            if(i == 0) nums[i] = suff[i + 1];
            else if(i == n - 1) nums[i] = pref[i - 1];
            else nums[i] = pref[i - 1] * suff[i + 1];
        }
        return nums;
    }
}