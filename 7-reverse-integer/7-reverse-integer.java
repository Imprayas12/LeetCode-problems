class Solution {
    public int reverse(int x) {
        boolean neg = false;
        if(x < 0) neg = true;
        long reverse_num = 0;
        while(x != 0) {
            reverse_num = reverse_num * 10 + x % 10;
            x /= 10;
        }
        return reverse_num > Integer.MAX_VALUE || reverse_num < Integer.MIN_VALUE ? 0: (int) reverse_num;
    }
}