class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer,List<List<Integer>>> map = new HashMap();
        for (int[] road : roads) {
            map.computeIfAbsent(road[0], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(road[1], road[2]));
            map.computeIfAbsent(road[1], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(road[0], road[2]));
        }
        return bfs(map, n);
    }
    private int bfs(Map<Integer,List<List<Integer>>> map, int n) {
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        vis[1] = true;
        int ans = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(!map.containsKey(node)) continue;
            for(List<Integer> list : map.get(node)) {
                ans = Math.min(ans, list.get(1));
                if(!vis[list.get(0)]) {
                    vis[list.get(0)] = true;
                    queue.add(list.get(0));
                }
            }
        }
        return ans;
    }
}