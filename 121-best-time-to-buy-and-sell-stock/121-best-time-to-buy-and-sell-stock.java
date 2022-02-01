class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1) return 0;
        int max=0;
        int buy=0;
        int sell=1;
        while(sell<prices.length){
            if(prices[sell]>prices[buy]){
                max = Math.max(prices[sell]-prices[buy],max);
            }
            else 
                    buy=sell;
            sell++;
        }
        return max;
    }
}