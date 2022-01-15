class Solution {
    Integer dp[];
    public int numTrees(int n) {
    dp= new Integer[n+1];
        return fact(n);
    }
    public int fact(int n){
        if(n<2) return 1;
        if(dp[n]!=null) return dp[n];
        int res=0;
        for(int i=n-1;i>=0;i--){
            res+=fact(i)*fact(n-i-1);
        }
        return dp[n]=res;
    }
}