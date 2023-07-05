class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int left = 0;
        int right = 0;
        while(right < nums.length) {
            int zeros_found = 0;
            while(right < nums.length) {
                if(nums[right] == 0) {
                    zeros_found += 1;
                }
                while(zeros_found > 1) {
                    if(nums[left] == 0) zeros_found -= 1;
                    left++;
                }
                ans = Math.max(ans, right - left);
                right += 1;
            }
        }
        return ans;
    }
}