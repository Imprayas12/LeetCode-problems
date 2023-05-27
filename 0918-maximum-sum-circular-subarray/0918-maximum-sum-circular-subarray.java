class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int pos = kadane(nums);
        int s = 0;
        for(int i = 0; i < nums.length; i++) { 
            s += nums[i];
            nums[i] *= -1;
        }
        int neg = kadane(nums);
        s += neg;
        if(s == 0) return pos;
        return Math.max(pos, s);
    }
    public int kadane(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxSum = Math.max(currentSum, maxSum);
            if(currentSum < 0) currentSum = 0;
        }
        return maxSum;
    }
}