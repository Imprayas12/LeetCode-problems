class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        set(nums,0,ans);
        return ans;
    }
    private void set(int[] arr,int index,List<List<Integer>> ans){
        if(index==arr.length){
            List<Integer> ds = new ArrayList<Integer>();
            for(int i=0;i<arr.length;i++) ds.add(arr[i]);
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<arr.length;i++){
            swap(arr,index,i);
            set(arr,index+1,ans);
            swap(arr,index,i);
        }
    }
    private void swap(int[] arr,int i,int j){
        int a = arr[i];
        arr[i]=arr[j];
        arr[j]=a;
    }
}