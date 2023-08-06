class Solution {
    int modulo = 1000000007;
    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] dp = new long[goal + 1][n + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= goal; i++) {
            for(int j = 1; j <= Math.min(i, n); j++) {
                dp[i][j] = dp[i - 1][j - 1] * (n - j + 1) % modulo;
                if(j > k) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - k)) % modulo;
                }
            }
        }
        return (int) dp[goal][n];
    }
}