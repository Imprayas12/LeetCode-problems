class Solution {
    public int partitionString(String s) {
        int idx = 0;
        Set<Character> set = new HashSet<>();
        int ans = 1;
        while(idx < s.length()) {
            while(idx < s.length() && !set.contains(s.charAt(idx))) {
                set.add(s.charAt(idx));
                idx++;
            }
            if(idx < s.length()) {
                ans += 1;
                set = new HashSet<>();
            }
        }
        return ans;
    }
}