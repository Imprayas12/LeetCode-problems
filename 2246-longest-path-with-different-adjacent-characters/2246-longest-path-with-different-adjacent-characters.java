class Solution {
    int max = 0;
    public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<parent.length; i++){
            int p = parent[i];
            if(p == -1){
                continue;
            }
            map.putIfAbsent(p, new ArrayList<>());
            map.get(p).add(i);
        }

        helper(0, map, s);
        return max;
    }
    
    private int helper(int curr, Map<Integer, List<Integer>> map, String s){
        int max1 = -1;
        int max2 = -1;
        for(int c : map.getOrDefault(curr, new ArrayList<>())){
            int res = helper(c, map, s);
            if(s.charAt(curr) != s.charAt(c)){
                if (res > max1) {
                    max2 = max1;
                    max1 = res;
                }
                else if (res > max2) {
                    max2 = res;
                }
            }
        }
        
        max1 = max1 == -1 ? 0 : max1;
        max2 = max2 == -1 ? 0 : max2;
        
        max = Math.max(max, max1 + max2 + 1);
        return max1 + 1;
    }
}