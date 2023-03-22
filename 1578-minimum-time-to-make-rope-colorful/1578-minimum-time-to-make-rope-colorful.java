class Solution {
    public int minCost(String colors, int[] neededTime) {
        int idx = 0;
        int ans = 0;
        while(idx < colors.length()) {
            char ch = colors.charAt(idx);
            int sum = neededTime[idx];
            idx++;
            int max = sum;
            while(idx < colors.length() && colors.charAt(idx) == ch) {
                max = Math.max(max, neededTime[idx]);
                sum += neededTime[idx];
                idx++;
            }
            ans += sum - max;
        }
        return ans;
    }
}