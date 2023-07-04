class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while(left < right) {
            right = (right & (right - 1));
        }
        return left & right;
    }
    private int nearestPowerOfTwo(int mid) {
        double pow = Math.log(mid)/Math.log(2);
        int big = (int) Math.pow(mid,(int) Math.ceil(pow));
        int small = (int) Math.pow(mid,(int) Math.floor(pow));
        if(big - mid > mid - small) return small;
        return big;
    }
}