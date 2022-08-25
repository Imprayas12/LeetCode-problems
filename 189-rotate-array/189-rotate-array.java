class Solution {
    public void rotate(int[] nums, int k) {
     /*For array to rotate k times... the lowest element of the array must be at kth index after rotations.*/
        k %= nums.length;
        if(nums.length==0 || nums.length==1 || k == 0) return;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0, k - 1);
        reverse(nums,k ,nums.length - 1);
    }
    private void reverse(int[] nums,int i,int j){ 
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}