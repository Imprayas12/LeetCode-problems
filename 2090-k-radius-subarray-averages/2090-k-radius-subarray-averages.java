class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n =  nums.length;
        long sum = 0;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        int left = 0, right = 0, windowSize = 2*k+1;
        while(right < n){
            sum += nums[right];
            if(right - left + 1 == windowSize){
                res[left + k] = (int) (sum / windowSize);
                sum -= nums[left];
                left++;
            }
            right++;
        }      
        return res;
    }
}