class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            int low = i + 1;
            int high = nums.length - 1;
            
            while(low < high) {
            int curSum = (nums[i] + nums[low] + nums[high]);
            if(Math.abs(target - curSum) == 0) return curSum;
            if(Math.abs(target - curSum) < Math.abs(target - result)) {
                result = curSum;
            }
                if(curSum > target) high--;
                else low++;
            }
        }
        return result;
    }
}