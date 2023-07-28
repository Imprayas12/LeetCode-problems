class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        return helper(nums, 0, n - 1) >= 0;
    }
    private int helper(int[] nums, int start, int end) {
        if(start == end) {
            return nums[start];
        }
        int left = nums[start] - helper(nums, start + 1, end);
        int right = nums[end] - helper(nums, start, end - 1);
        return Math.max(left, right);
    }
}