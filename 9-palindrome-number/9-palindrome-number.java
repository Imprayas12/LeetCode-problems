class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int c=x;
        int s=0;
        while(c!=0){
            s=s*10+c%10;
            c/=10;
        }
        return (s==x);
    }
}