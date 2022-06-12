class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int cur=0;
        int prev=0;
        int curSum = 0;
        int ans = 0;
        Set<Integer> set = new HashSet();
        while(cur< nums.length && prev < nums.length){
            if(!set.contains(nums[cur])){
                set.add(nums[cur]);
                curSum += nums[cur++];
                ans = Math.max(ans,curSum);
            }
            else{
                set.remove(nums[prev]);
                curSum -= nums[prev++];
            }
        }
        return ans;
    }
}