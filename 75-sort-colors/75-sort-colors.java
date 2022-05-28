class Solution {
    public void sortColors(int[] nums) {
        if (nums.length<2) return;
        int low = 0;
        int high = nums.length-1;
        int i=0;
        while(i<=high){
            if(nums[i]==0)
            {
                swap(low,i,nums);
                low++; i++;
            }
            else if(nums[i]==2){
                swap(high,i,nums);
                high--;
            }
            else if(nums[i]==1) i++;
        }
    }
    public void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}