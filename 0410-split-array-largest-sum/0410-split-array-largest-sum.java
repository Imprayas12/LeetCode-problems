class Solution {
    public int splitArray(int[] nums, int k) {
        int low = IntStream.of(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        int min = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (low + high)/2;
            if(isValid(mid,nums,k)) {
                min = Math.min(min,mid);
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return min;
    }
    private boolean isValid(int mid,int[] nums,int k) {
        int count = 0;
        int low = 0;
        while(low < nums.length) {
            int sum = 0;
            while(low < nums.length && sum + nums[low] <= mid) sum += nums[low++]; 
            count++;
        }
        return count <= k;
    }
}