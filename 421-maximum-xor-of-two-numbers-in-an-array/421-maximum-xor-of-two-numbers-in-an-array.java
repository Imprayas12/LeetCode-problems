class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask=0;
        int max=0;
        for(int i=31;i>=0;i--){
            mask = mask|1<<i;
            Set<Integer> st = new HashSet<>();
            for(var num : nums){
                st.add(num & mask);
            }
            int temp = max | (1<<i);
            for(int num : st){
                if(st.contains(temp^num)){
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }
}