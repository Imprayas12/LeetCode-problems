class Solution {
    public int findMin(int[] nums) {
        int lo = 0,hi = nums.length -1;
        while(lo < hi){
            while(lo < nums.length - 2 && nums[lo] == nums[lo + 1]) lo++;
            while(hi > 0 && nums[hi - 1] == nums[hi]) hi--;
            int mid = (lo + hi)/2;
            if(nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        return nums[hi];
    }
}