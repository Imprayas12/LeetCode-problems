class Solution {
    public int myAtoi(String s) {
        int sign=1;
        int r=0;
        int index=0;
        int n = s.length();
        while(index<n && s.charAt(index)==' ') index++;
        if(index< n && s.charAt(index)=='+'){
            sign =1; index++;
        }
        else if(index<n && s.charAt(index)=='-') {
            sign=-1;
            index++;
        }
        while(index<n && Character.isDigit(s.charAt(index))) {
            int d=s.charAt(index)-'0';
              if((r > Integer.MAX_VALUE/10)|| 
                (r == Integer.MAX_VALUE/10 && d>Integer.MAX_VALUE%10)){
                  return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
            r=r*10+d;
            index++;
    }
        return sign*r;
    }
}