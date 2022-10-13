class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int ans = 0;
        while(i < j) {
            int mid = i + (j - i)/2;
            if(nums[mid] > nums[mid + 1]) {
                j = mid;
                ans = mid;
            }
            else {
                i = mid + 1;
                ans = i;
            }
        }
        return ans;
    }
}