class Solution {
    class Pair {
        int val;
        int count;
        Pair(int val,int count){
            this.val = val;
            this.count = count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.count - a.count);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: nums) map.put(i, map.getOrDefault(i,0) + 1);
        for(Map.Entry<Integer,Integer> m: map.entrySet()) {
            pq.offer(new Pair(m.getKey(), m.getValue()));
        }
        int[] ans = new int[k];
        k--;
        while(k >= 0) {
            ans[k--] = pq.poll().val;
        }
        return ans;
    }
}