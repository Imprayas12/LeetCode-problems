class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10002];
        for(int i: nums) count[i] += i;
        for(int i = 2; i < count.length; i++) {
            count[i] = Math.max(count[i - 1], count[i - 2] + count[i]);
        }
        return count[10001];
    }   
}