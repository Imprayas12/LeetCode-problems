class Solution {
    public int longestCommonSubsequence(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (var i: dp) Arrays.fill(i, -1);
    return longCS(word1.length() - 1, word2.length() - 1, word1, word2, dp);
  }
  private int longCS(int ind1, int ind2, String word1, String word2, int[][] dp) {
    if (ind1 < 0 || ind2 < 0)
      return 0;
    if (dp[ind1][ind2] != -1) return dp[ind1][ind2];
    if (word1.charAt(ind1) == word2.charAt(ind2))
      return dp[ind1][ind2] = 1 + longCS(ind1 - 1, ind2 - 1, word1, word2, dp);
    else
      return dp[ind1][ind2] = Math.max(longCS(ind1, ind2 - 1, word1, word2, dp), longCS(ind1 - 1, ind2, word1, word2, dp));
  }
}