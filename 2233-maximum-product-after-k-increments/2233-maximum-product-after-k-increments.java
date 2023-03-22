class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: nums) pq.add(i);
        int mod = (int) (Math.pow(10,9)) + 7;
        while(k-->0) {
            pq.add(pq.poll() + 1);
        }
        long prod = 1;
        while(!pq.isEmpty()){
            prod = ((prod % mod) * (pq.poll() % mod)) % mod;
        }
        return (int)prod;
    }
}