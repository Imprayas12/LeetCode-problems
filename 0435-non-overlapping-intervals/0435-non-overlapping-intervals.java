class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int ans = 0;
        int k = Integer.MIN_VALUE;
        for(int[] i: intervals) {
            if(i[0] >= k) {
                k = i[1];
            }
            else ans += 1;
        }
        return ans;
    }
}