class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int i: nums) {
            if(i > 0) {
                set.add(i);
            }
            max = Math.max(i,max);
        }
        for(int i = 1; i <= max; i++){
            if(!set.contains(i))
                return i;
        }
        return max + 1;
    }
}