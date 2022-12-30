class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(0);
        dfs(graph,0,ans,currentPath);
        return ans;
    }
    private void dfs(int[][] graph,int node,List<List<Integer>> ans, List<Integer> currentPath) {
        if(node == graph.length - 1) {
            ans.add(new ArrayList<>(currentPath));
            return;
        }
        for(int i: graph[node]) {
            currentPath.add(i);
            dfs(graph,i,ans,currentPath);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}