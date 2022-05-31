class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        set(nums,ans,new ArrayList<Integer>(),new HashMap<Integer,Boolean>());
        return ans;
    }
    private void set(int[] arr,List<List<Integer>> ans,List<Integer> ds,HashMap<Integer,Boolean> map){
        if(ds.size()==arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                ds.add(arr[i]);
                map.put(arr[i],true);
                set(arr,ans,ds,map);
                ds.remove(ds.size()-1);
                map.remove(arr[i]);
            }
        }
    }
}