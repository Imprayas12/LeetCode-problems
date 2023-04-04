class Solution {
    int[] rank;
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        rank = new int[n + 1];
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) parent[i] = i;
        for(int[] i: edges) {
            int p1 = find(i[0]);
            int p2 = find(i[1]);
            if(p1 == p2) return new int[]{i[0],i[1]};
            unionByRank(p1, p2);
        }
        return new int[]{-1,-1};
    }
    private int find(int node) {
        if(node == parent[node]) return node;
        return parent[node] = find(parent[node]);
    }
    private void unionByRank(int v1, int v2) {
        int parent_v1 = find(v1);
        int parent_v2 = find(v2);
        if(parent_v1 != parent_v2) {
            if (rank[parent_v1] == rank[parent_v2]) {
                parent[parent_v1] = parent_v2;
                rank[parent_v2] += 1;
            } else if (rank[parent_v1] < rank[parent_v2]) {
                parent[parent_v1] = parent_v2;
            } else {
                parent[parent_v2] = parent_v1;
            }
        }
    }
}