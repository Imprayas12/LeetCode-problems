class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int left = 0;
        while(left < nums.length) {
                long len = 0;
                while(left < nums.length && nums[left] == 0) {
                    left++;
                    len++;
                }
            ans += len * (len + 1)/2;
            left++;
        }
        return ans;
    }
}