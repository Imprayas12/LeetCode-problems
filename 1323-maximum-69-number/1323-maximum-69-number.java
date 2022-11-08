class Solution {
    public int maximum69Number (int num) {
        char[] number = String.valueOf(num).toCharArray();
        String ans = "";
        boolean flag = false;
        for(int i = 0; i < number.length; i++) {
            if(number[i] == '6' & !flag) {
                ans += '9';
                flag = true;
            }
            else ans += number[i];
        }
        return Integer.parseInt(ans);
    }
}