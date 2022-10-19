class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);   
        List<List<Integer>> ans = new ArrayList<>();
        recur(candidates,ans,target,0,new ArrayList<>());

        return ans;
    }
    private void recur(int[] candidates,List<List<Integer>> ans,int target,int idx,List<Integer> cur) {
        if(target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = idx; i < candidates.length; i++) {
            if(i > idx && candidates[i] == candidates[i - 1]) continue;
            if(candidates[i] > target) return;
            cur.add(candidates[i]);
            recur(candidates,ans,target - candidates[i],i + 1,cur);
            cur.remove(cur.size() - 1);
        }
    }
}