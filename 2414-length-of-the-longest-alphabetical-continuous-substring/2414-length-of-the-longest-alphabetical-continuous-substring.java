class Solution {
    public int longestContinuousSubstring(String s) {
        int start = 0;
        int end = 1;
        int ans = 1;
        int n = s.length();
        while(end < n) {
            if(ans == 26) break;
            if(s.charAt(end) == s.charAt(end - 1) + 1) {
                ans = Math.max(ans, end - start + 1);
                end++;
            }
            else {
                start = end;
                end += 1;
            }
        }
        return ans;
    }
}