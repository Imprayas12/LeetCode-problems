class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
       if(k <= 1) return 0;
        int low = 0;
        int high = 0;
        int prod = 1;
        int res = 0;
        while(high < nums.length) {
            prod *= nums[high];
            while(prod >= k && low < nums.length) prod /= nums[low++];
            res += (high - low + 1) > 0 ? high - low + 1: 0;
            high++;
        }
        return res;
    }
}