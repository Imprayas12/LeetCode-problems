class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        ans = 0
        left = 0
        right = 0
        while right < len(nums):
            zeros_found = 0
            while right < len(nums):
                if nums[right] == 0:
                    zeros_found += 1
                while zeros_found > 1:
                    if nums[left] == 0:
                        zeros_found -= 1
                    left += 1
                ans = max(ans, right - left)
                right += 1
        return ans
        