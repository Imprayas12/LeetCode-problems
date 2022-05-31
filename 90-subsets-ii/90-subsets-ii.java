class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubs(0,nums,ans,new ArrayList<>());
        return ans;
    }
    private void findSubs(int index,int[] arr,List<List<Integer>> ans  , List<Integer> ds){
        for(int i=index;i<arr.length;i++){
            if(i==index || arr[i]!=arr[i-1]) {
            ds.add(arr[i]);
            findSubs(i+1,arr,ans,ds);
            ds.remove(ds.size()-1);
            }
        }
        ans.add(new ArrayList<>(ds));
    }
}