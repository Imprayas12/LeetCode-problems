class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        recur(ans,new ArrayList<>(),k,n,arr,0);
        return ans;
    }
    private void recur(List<List<Integer>> ans, List<Integer> ds, int k,int n,int[] arr,int ind) {
        if(ind == arr.length) {
            if(k == 0 && n == 0)
                ans.add(new ArrayList<>(ds));
            return;
        }
        if(k == 0 && n == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(k == 0 || n == 0) return;
        ds.add(arr[ind]);
        recur(ans,ds,k - 1,n - arr[ind],arr,ind+1);
        ds.remove(ds.size() - 1);
        recur(ans,ds,k,n,arr,ind+1);
        return;
    }
}