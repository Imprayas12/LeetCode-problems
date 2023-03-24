class Solution {
    int ans = 0;
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(connection[1], 1));
            adj.computeIfAbsent(connection[1], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(connection[0], 0));
        }
        dfs(0, -1, adj);
        return ans;
    }
    private void dfs(int node, int parent, Map<Integer, List<List<Integer>>> graph) {
        if(!graph.containsKey(node)) return;
        for(List<Integer> list: graph.get(node)) {
            int child = list.get(0);
            int notFake = list.get(1);
            if(child != parent) {
                ans += notFake;
                dfs(child, node, graph);
            }
        }
    }
}