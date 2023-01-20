class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        subsequences(ans,new ArrayList<>(),0,nums);
        return new ArrayList<>(ans);
    }
    private void subsequences(Set<List<Integer>> ans,List<Integer> current,int index,int[] nums) {
        if(index == nums.length) {
            if(current.size() >= 2)
            ans.add(new ArrayList<>(current));
            return;
        }
        if(current.size() == 0 || nums[index] >= current.get(current.size() - 1)) {
            current.add(nums[index]);
            subsequences(ans,current,index + 1,nums);
            current.remove(current.size() - 1);
        }
        subsequences(ans,current,index + 1,nums);
    }
    
}