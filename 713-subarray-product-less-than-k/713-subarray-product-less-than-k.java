class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int low = 0;
        int high = 0;
        int prod = 1;
        int res = 0;
        for(high = 0; high < nums.length;high++) {
            prod *= nums[high];
            while(prod >= k) prod /= nums[low++];
            res += high - low + 1;
        }
        return res;
    }
}