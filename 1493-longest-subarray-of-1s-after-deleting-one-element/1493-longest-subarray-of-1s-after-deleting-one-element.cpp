class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int ans = 0;
        int left = 0;
        int right = 0;
        while (right < nums.size()) {
            int zeros_found = 0;
            while (right < nums.size()) {
                if (nums[right] == 0) {
                    zeros_found += 1;
                }
                while (zeros_found > 1) {
                    if (nums[left] == 0) {
                        zeros_found -= 1;
                    }
                    left++;
                }
                ans = max(ans, right - left);
                right += 1;
            }
        }
        return ans;
    }
};