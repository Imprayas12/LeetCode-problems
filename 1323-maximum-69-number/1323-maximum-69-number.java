class Solution {
    public int maximum69Number (int num) {
        char[] number = String.valueOf(num).toCharArray();
        int ans = 0;
        boolean flag = false;
        for(int i = 0; i < number.length; i++) {
            if(number[i] == '6' & !flag) {
                ans = ans * 10 + '9' - '0';
                flag = true;
            }
            else ans = ans* 10 + number[i] - '0';
        }
        return ans;
    }
}