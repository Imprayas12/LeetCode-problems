class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        set(nums,ans,new ArrayList<Integer>(),new boolean[nums.length]);
        return ans;
    }
    private void set(int[] arr,List<List<Integer>> ans,List<Integer> ds,boolean[] freq){
        if(ds.size()==arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(arr[i]);
                set(arr,ans,ds,freq);
                ds.remove(ds.size()-1);
                freq[i]=false;
                }
            }
        }
}