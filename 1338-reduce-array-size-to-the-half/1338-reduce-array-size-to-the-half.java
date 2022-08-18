class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int[] ar = new int[map.size()];
        int i = 0;
        for(Map.Entry<Integer,Integer> m: map.entrySet()) {
            pq.add(m.getValue());
        }
        int sum = 0;
        int len = 0;
        while(!pq.isEmpty()) {
            sum += pq.poll();
            len += 1;
            if(sum >= arr.length/2) return len;
        }
        
        return len;
    }
}