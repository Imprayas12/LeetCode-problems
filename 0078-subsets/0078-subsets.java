class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    helper(nums,ans,new ArrayList<>(),0); 
      return ans;
    }
    private void helper(int[] nums,List<List<Integer>> ans,List<Integer> cur,int ind) {
        if(ind == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        helper(nums,ans,cur,ind + 1);
        cur.add(nums[ind]);
        helper(nums,ans,cur,ind + 1);
        cur.remove(cur.size() -1);
    }
}