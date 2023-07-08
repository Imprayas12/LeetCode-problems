public class Solution {
    public int hammingWeight(int n) {
        int rmsb = n & -n;
        int ans = 0;
        while(rmsb != 0) {
            ans += 1;
            n = n ^ rmsb;
            rmsb = n & -n;
        }
        return ans;
    }
}