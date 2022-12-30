class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for(int i: nums){
            pq.add((double)i);
            sum += (double)i;
        } 
        double RunningSum = sum;
        int ans = 0;
        while(true) {
            ans += 1;
            double val = (double)pq.poll();
            RunningSum -= val/2;
            if(RunningSum <= sum/2) break;
            pq.add(val/2);
        }
        return ans;
    }
}