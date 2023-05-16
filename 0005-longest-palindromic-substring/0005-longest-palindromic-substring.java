class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = -1;
        int end = -1;
        boolean[][] dp = new boolean[n][n];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if(dp[i][j] && (j - i + 1) >= (end - start + 1)) {
                    start = i;
                    end = j;
                }
            }
        }
        return start == -1 ? "": s.substring(start, end + 1);
    }
}