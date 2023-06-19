class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int al = 0;
        for(int i: gain) {
            al += i;
            ans = Math.max(al, ans);
        }
        return ans;
    }
}