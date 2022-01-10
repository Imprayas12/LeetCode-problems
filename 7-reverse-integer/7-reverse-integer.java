class Solution {
    public int reverse(int x) {
        long a = 0;
        boolean flag = false;
        if(x<0) flag=true;
        while(x!=0){
            a=a*10+x%10;
            x/=10;
        }
        if(a>Integer.MAX_VALUE || a<Integer.MIN_VALUE) return 0;
        return (int)a;
    }
}