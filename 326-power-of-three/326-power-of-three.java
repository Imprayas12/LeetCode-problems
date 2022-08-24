class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 1) return true;
        return recur((double)n);
    }
    private boolean recur(double n) {
        if(n < 3) return false;
        if(n == 3) return true;
        return recur(n / 3.0);
    }
}