class Solution {
    public long putMarbles(int[] weights, int k) {
        if(k == 1 || k == weights.length) return 0;
        long ans = 0;
        long ans2 = 0;
        k -= 1;
        List<Long> list1 = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();
        for(int i = 0; i < weights.length - 1; i++) {
            list1.add((long)(weights[i] + weights[i + 1]));
            list2.add((long)(weights[i] + weights[i + 1]));
        }
        Collections.sort(list1);
        Collections.reverse(list1);
        Collections.sort(list2);
        for(int i = 0; i < k; i++) {
            ans += list1.get(i);
            ans2 += list2.get(i);
        }
       
        return ans - ans2;
        
    }
}