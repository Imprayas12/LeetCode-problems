class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] connection: connections) {
            graph.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(connection[1]);
            graph.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(connection[0]);
        }
        int connectionComponents = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                connectionComponents += 1;
                dfs(graph, vis, i);
            }
        }
        return connectionComponents - 1;
    }
    private void dfs(Map<Integer, List<Integer>> graph, boolean[] vis, int node) {
        vis[node] = true;
        if(!graph.containsKey(node)) return;
        for(int n : graph.get(node)) {
            if(!vis[n]) dfs(graph, vis, n);
        }
    }
}