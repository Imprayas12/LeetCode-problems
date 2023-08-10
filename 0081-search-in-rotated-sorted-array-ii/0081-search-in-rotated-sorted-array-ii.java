class Solution {
    public boolean search(int[] nums, int target) {
    if(nums.length == 1) return nums[0] == target;
        int lo = 0,hi = nums.length -1;
        while(lo < nums.length - 2 && nums[lo] == nums[lo + 1]) lo++;
        while(hi > 0 && nums[hi - 1] == nums[hi]) hi--;
        while(lo < hi){
            int mid = (lo + hi)/2;
            if(nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        int start = hi;
        if(nums[start] <= target && target <= nums[nums.length - 1]) {
            return binSearch(start,nums.length - 1,target,nums);
        }
        else {
            return binSearch(0,start - 1,target,nums); 
        }
    }
    private boolean binSearch(int lo,int hi,int target,int[] nums){
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] > target)
                hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    } 
}