class Solution {
    int ans = -1;
    public int longestCycle(int[] edges) {
        boolean[] vis = new boolean[edges.length];
        for(int i = 0; i < edges.length; i++) {
            if(!vis[i]) {
                Map<Integer,Integer> distance = new HashMap<>();
                distance.put(i, 1);
                dfs(i, distance, edges, vis);
            }
        }
        return ans;
    }
    private void dfs(int node, Map<Integer, Integer> map, int[] edges, boolean[] vis){
        vis[node] = true;
        int neighbour = edges[node];
        if(neighbour != -1 && !vis[neighbour]) {
            map.put(neighbour, map.get(node) + 1);
            dfs(neighbour, map, edges, vis);
        }
        else if(neighbour != -1 && map.containsKey(neighbour)) {
            ans = Math.max(ans, map.get(node) - map.get(neighbour) + 1);
        }
    }
}