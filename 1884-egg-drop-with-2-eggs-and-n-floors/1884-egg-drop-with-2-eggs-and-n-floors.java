class Solution {
    public int twoEggDrop(int n) {
        int ans = 1;
        for(int i = 1; i < n; i += ans) {
            ans += 1;
        }
        return ans;
    }
}
