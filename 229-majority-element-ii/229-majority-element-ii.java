class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int num1=0,num2=0,count1=0,count2=0;
        for(int num: nums){
            if(num==num1)
                count1++;
            else if(num==num2)
                count2++;
            else if(count1==0)
            {
                num1=num;
                count1=1;
            }
            else if(count2==0)
            {
                count2=1;
                num2=num;
            }
            else {
                count1--;count2--;
            }
        }
        count1=0;
        count2=0;
        for(int num:nums){
            if(num==num1)
                count1++;
            else if(num==num2)
                count2++;
            if(count1>nums.length/3 && !ans.contains(num1))
                ans.add(num1);
            if(count2>nums.length/3 && !ans.contains(num2))
                ans.add(num2);
        }
        return ans;
    }
}