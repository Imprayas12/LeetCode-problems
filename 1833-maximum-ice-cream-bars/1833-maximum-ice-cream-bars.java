class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int idx = 0;
        int ans = 0;
        while(coins > 0 && idx < costs.length) {
            if(costs[idx] <= coins) {
                coins -= costs[idx];
                ans++;
            }
            idx++;
        }
        return ans;
    }
}