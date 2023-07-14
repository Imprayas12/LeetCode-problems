class Solution {
    public int longestSubsequence(int[] arr, int difference) {
       Map<Integer, Integer> hash = new HashMap<>();
        int ans = 1;
        for(int i: arr) {
            int prev = hash.getOrDefault(i - difference, 0);
            hash.put(i, prev + 1);
            ans = Math.max(ans, hash.get(i));
        }
        return ans;
    }
}