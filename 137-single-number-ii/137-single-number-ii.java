class Solution {
    public int singleNumber(int[] nums) {
        int one_time = 0;
        int second = 0;
        int cbm = 0;
        for(int i = 0;i<nums.length;i++){
            second = second | (one_time & nums[i]);
            one_time = one_time^ nums[i];
            cbm = ~(one_time & second);
            one_time &= cbm;
            second &= cbm;
        }
        return one_time;
    }
}