class Solution {
    public int maximumGap(int[] nums) {
        //Naive solution
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - 1; i++) {
            max = Math.max(nums[i + 1] - nums[i],max);
        }
        return max;
    }
}