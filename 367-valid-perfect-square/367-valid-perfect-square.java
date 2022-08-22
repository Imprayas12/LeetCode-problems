class Solution {
    public boolean isPerfectSquare(int num) {
        for(double i = 1; i * i <= num; i++) {
            if((double)i == (double)num/(double) i) return true;
        }
        return false;
    }
}