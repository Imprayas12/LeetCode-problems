class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length ==  0) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        int num1 = nums[0];
        int num2 = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == num2 + 1) {
                num2 = nums[i];
            }
            else {
                if(num2 == num1) {
                    list.add("" + num1);
                }
                else list.add(num1 + "->" + num2);
                num1 = nums[i];
                num2 = nums[i];
            }
        }
        if(num1 == num2) list.add("" + num2);
        else list.add(num1 + "->" + num2);
        return list;
    }
}