class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(b[1],               a[1]) : Integer.compare(a[0], b[0]));
        int ans = 1, start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= start && intervals[i][1] <= end) {
                continue;
            }
            ans += 1;
            start = intervals[i][0];
            end = intervals[i][1];
        }
        return ans;
    }
}