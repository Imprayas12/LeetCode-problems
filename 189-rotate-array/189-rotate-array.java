class Solution {
    public void rotate(int[] nums, int k) {
     /*For array to rotate k times... the lowest element of the array must be at kth index after rotations.*/
        k%=nums.length;
        if(nums.length==0||nums.length==1) return;
        int[] newnum = new int[nums.length];
        int j=0;
        for(int i=k;i<newnum.length;i++){
            newnum[i]=nums[j++];
        }
        for(int i=0;i<k;i++){
            newnum[i]=nums[j++];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=newnum[i];
        }
    }
}