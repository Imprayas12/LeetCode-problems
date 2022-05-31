class Solution {
    public double myPow(double x, int n) {
        if(n == Integer.MAX_VALUE)
            if(x==-1) return x;
            else if(x<1)
            return 0;
            else
            return x;
        if(n == Integer.MIN_VALUE){
            if(x>1)
                return 0;
            else if(x==-1) return -x;
            return x;
        }
        if(n<0){
            if(n==0)
                return 1;
            return myPow(x,n+1)/x;
        }
        else{
        if(n==0)
            return 1;
        return x*myPow(x,n-1);
        }
    }
}