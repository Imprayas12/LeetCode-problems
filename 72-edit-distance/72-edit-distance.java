class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(var i: dp) Arrays.fill(i, -1);
        return minD(word1.length()-1,word2.length()-1,word1,word2,dp);
    }
    private int minD(int ind1,int ind2,String s1,String s2,int[][] dp){
        if(ind1<0) return ind2+1;
        if(ind2<0) return ind1+1;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2))
            return minD(ind1-1,ind2-1,s1,s2,dp);
        else{
            return dp[ind1][ind2] = 1 + Math.min(minD(ind1-1,ind2-1,s1,s2,dp),Math.min(minD(ind1,ind2-1,s1,s2,dp),minD(ind1-1,ind2,s1,s2,dp)));
        }
    }
}