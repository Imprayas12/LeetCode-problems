class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;
        int reversed_num = 0;
        while(reversed_num < x) {
            int unit_digit = x % 10;
            reversed_num = reversed_num * 10 + unit_digit;
            x /= 10;
        }
        return reversed_num == x || x == reversed_num / 10;
    }
}