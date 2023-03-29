class Solution {
    
    public int longestCycle(int[] edges) {
        int[] indegree = new int[edges.length];
        for(int i = 0; i < edges.length; i++) {
            if(edges[i] != -1) indegree[edges[i]] += 1;
        }
        boolean[] vis = new boolean[edges.length];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < edges.length; i++) {
            if(indegree[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            int node = queue.poll();
            vis[node] = true;
            int neighbour = edges[node];
            if(neighbour != -1) {
                indegree[neighbour] -= 1;
                if(indegree[neighbour] == 0)
                queue.add(neighbour);
            }
        }
        int ans = -1;
        for(int i = 0; i < vis.length; i++) {
            if(!vis[i]) {
                int count = 1;
                int neighbour = edges[i];
                while(neighbour != i) {
                    count += 1;
                    vis[neighbour] = true;
                    neighbour = edges[neighbour];
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}