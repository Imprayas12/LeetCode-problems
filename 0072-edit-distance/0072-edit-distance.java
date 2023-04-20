class Solution {
    public int minDistance(String word1, String word2) {
        return bottomUp(word1, word2);
    }
    private int minimum(String s1, String s2, int i, int j, int[][] dp) {
        if(i == s1.length()) return s2.length() - j;
        if(j == s2.length()) return s1.length() - i;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = minimum(s1, s2, i + 1, j + 1,dp);
        }
        return dp[i][j] = 1 + Math.min(minimum(s1, s2, i + 1, j + 1,dp), Math.min(minimum(s1, s2, i + 1, j, dp), minimum(s1, s2, i, j + 1, dp)));
    }
    private int bottomUp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i < dp[0].length; i++) dp[0][i] = i;
        for(int i = 0; i < dp.length; i++) dp[i][0] = i;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}