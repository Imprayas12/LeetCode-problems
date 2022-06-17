class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(var i: dp) Arrays.fill(i, -1);
        return disSubs(s.length()-1,t.length()-1,s,t,dp);
    }
    private int disSubs(int ind1,int ind2,String s,String t,int[][] dp){
        
         if(ind2<0) return 1; 
        if(ind1<0) return 0;
       if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(s.charAt(ind1)==t.charAt(ind2)){
            return dp[ind1][ind2] = disSubs(ind1-1,ind2-1,s,t,dp)+disSubs(ind1-1,ind2,s,t,dp);
        }
        else{
            return  dp[ind1][ind2] =  disSubs(ind1-1,ind2,s,t,dp);
        }
    }
}