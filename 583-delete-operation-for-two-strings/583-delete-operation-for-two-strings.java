class Solution {
    public int minDistance(String word1, String word2) {
        int length = word1.length() + word2.length();
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int ind1=1;ind1<word1.length()+1;ind1++){
            for(int ind2=1;ind2<word2.length()+1;ind2++){
                if(word1.charAt(ind1-1)==word2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }
            return word1.length() + word2.length()- 2*dp[word1.length()][word2.length()];
    }
}