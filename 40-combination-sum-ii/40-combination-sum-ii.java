class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCombs(0,candidates,target,ans,new ArrayList<Integer>());
        return ans;
    }
    private void findCombs(int index, int[] arr,int target,List<List<Integer>> ans,List<Integer> ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            ds.add(arr[i]);
            findCombs(i+1,arr,target-arr[i],ans,ds);
            ds.remove(ds.size()-1);
        }
        
    }
}