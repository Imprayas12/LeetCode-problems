class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int n = nums.length;
        for (int j = n - n / 2; j < n; ++j)
            left += 2 * nums[left] <= nums[j] ? 1 : 0;
        return left * 2;
    }
}