class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] colors = new int[v];
        Arrays.fill(colors,-1);
        for(int i = 0; i < v; i++) {
            if(colors[i] == -1) {
                if(!dfs(colors,0,graph,i)) return false; 
            }
        }
        return true;
    }
    private boolean check(int[] colors,int[][] graph,int vertex,int V) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(vertex);
        while(!queue.isEmpty()) {
            vertex = queue.poll();
            for(int node: graph[vertex]) {
                if(colors[node] == -1) {
                    colors[node] = ~colors[vertex];
                    queue.add(node);
                }
                else if(colors[node] == colors[vertex]) return false;
            }
        }
        return true;
    }
    private boolean dfs(int[] colors,int color,int[][] graph,int node) {
        colors[node] = color;
        for(var it: graph[node]) {
            if(colors[it] == -1) {
                if(dfs(colors,1-color,graph,it) == false) return false; 
            }
            else if(colors[it] == color) return false;
        }
        return true;
    }
}