class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        long left = 1;
        long right = num;
        while(left <= right) {
            long mid = left + (right - left) /2;
            long sq = mid * mid;
            if(sq == num) return true;
            if(sq > num) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}

// 1 = 1
// 1 + 3 = 4
// 1 + 3 + 5 = 9
// 1 + 3 + 5 + 7 = 16 
// 1 + 3 + 5 + 7 + 9 = 25