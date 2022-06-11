class Solution {
    public boolean isHappy(int n) {
    Set<Integer> seen = new HashSet();
        int c=n;
        int sum=0;
        while(sum!=1){
            while(c!=0){
                int f = c%10;
                sum+=f*f;
                c/=10;
            }
            if(sum==1) break;
            if(seen.contains(sum)) return false;
            seen.add(sum);
            c=sum;
            sum=0;
        }
        return true;
    }
}