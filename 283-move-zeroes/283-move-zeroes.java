class Solution {
    public void moveZeroes(int[] nums) {
        for(int last_zero=0,last_pos=0;last_pos<nums.length;last_pos++)
        if(nums[last_pos]!=0){
            swap(last_zero,last_pos,nums);
            last_zero++;
        }
    }
     public static void swap(int a,int b,int[] arr){
        int f = arr[a];
         arr[a] = arr[b];
         arr[b] = f;
    }
}