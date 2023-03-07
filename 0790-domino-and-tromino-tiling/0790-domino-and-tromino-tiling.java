class Solution {
    public int numTilings(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 5;
        int mod = 1000000007;
        int[] ans = new int[n];
        ans[0] = 1;
        ans[1] = 2;
        ans[2] = 5;
        for(int i = 3; i < n; i++) {
            ans[i] = (((ans[i - 1] % mod) * 2)% mod + ans[i - 3] % mod) % mod;
        }
        return ans[n - 1]; 
    }
}