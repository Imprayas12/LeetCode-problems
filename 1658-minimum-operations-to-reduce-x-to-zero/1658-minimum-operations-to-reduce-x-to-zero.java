class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        int n = nums.length;
        for(var i: nums) sum+=i;
        if(sum == x) return n;
        if(sum < x) return -1;
        sum = sum -x;
        int i=0,cur_sum=0,ans=-1;
        for(int k=0;k<n;k++){
         cur_sum += nums[k];
            while(i<k && cur_sum > sum)
                cur_sum -= nums[i++];
            if(cur_sum == sum)
                ans = Math.max(ans,k-i+1);
        }
        if(ans==-1) return -1;
        return n-ans;
    }
}