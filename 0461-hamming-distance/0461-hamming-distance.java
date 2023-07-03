class Solution {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        for(int i = 1; i <= 32; i++) {
            if(((x >> i) & 1) != ((y >> i) & 1)) ans += 1;
        }
        return ans;
    }
}