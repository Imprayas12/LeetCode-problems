class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] pref = new int[nums.length];
       pref[0] = nums[0];
       for(int i = 1; i < nums.length; i++){
           pref[i] = pref[i - 1] * nums[i];
       }
        int[] suff = new int[nums.length];
        suff[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            suff[i] = suff[i + 1] * nums[i];
        }
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0) ans[i] = suff[i + 1];
            else if(i == nums.length - 1) ans[i] = pref[i - 1];
            else
                ans[i] = pref[i - 1] * suff[i + 1];
        }
        return ans;
    }
}