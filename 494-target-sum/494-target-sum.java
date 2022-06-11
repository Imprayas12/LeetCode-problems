class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return Ways(nums.length-1,nums,target);
    }
    private int Ways(int ind,int[] arr,int target){
        if(ind==0){
            if(arr[ind]==target && arr[ind]==-target) return 2;
            if(arr[ind]==target) return 1;
            if(arr[ind]==-target) return 1;
            return 0;
        }
        int pos = Ways(ind-1,arr,target+arr[ind]);
        int neg = Ways(ind-1,arr,target-arr[ind]);
        return pos+neg;
    }
}