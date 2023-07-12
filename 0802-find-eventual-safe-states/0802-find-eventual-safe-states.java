class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        int[] vis = new int[v];
        int[] pathVis = new int[v];
        int[] check = new int[v];
        for(int i = 0; i < v; i++) {
            if(vis[i] == 0) {
                dfsCheck(vis,pathVis,check,graph,i);
            }
        }
        List<Integer> ans = new LinkedList<>();
        for(int i = 0; i < v; i++) {
            if(check[i] == 1) ans.add(i);
        }
        return ans;
    }
    private boolean dfsCheck(int[] vis,int[] pathVis,int[] check,int[][] graph,int node) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        for(var it: graph[node]) {
            if(vis[it] == 0) {
                if(dfsCheck(vis,pathVis,check,graph,it)) {
                    return true;
                } 
            }
            else if(pathVis[it] == 1){
                  return true;  
            }
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
}