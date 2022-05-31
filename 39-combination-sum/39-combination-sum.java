class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0,candidates,ans,new ArrayList<Integer>(),target);
        return ans;
    }
private void findCombinations(int index,int[] arr,List<List<Integer>> ans, List<Integer> ds,int target){
        if(index == arr.length){
            if(target==0)
                ans.add(new ArrayList<>(ds));
            return;
        }
        if(arr[index]<=target){
            ds.add(arr[index]);
            findCombinations(index,arr,ans,ds,target-arr[index]);
            ds.remove(ds.size()-1);
        }
        findCombinations(index+1,arr,ans,ds,target);
    } 
}