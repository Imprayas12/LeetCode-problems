class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
       if(k == 0) return 0;
        int low = 0;
        int high = 0;
        int prod = 1;
        int res = 0;
        int i = 1;
        while(high < nums.length) {
            prod *= nums[high];
            System.out.println(prod);
            if(prod >= k) {
                while(prod >= k && low < nums.length) prod /= nums[low++];
                // i = 1;
            }
            res += (high - low + 1) > 0 ? high - low + 1: 0;
            high++;
            System.out.println(prod);
        }
        return res;
    }
}