class Solution {
    int[] parent;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        int[] candidate1 = {-1,-1};
        int[] candidate2 = new int[]{-1,-1};
        for(int[] i: edges) {
            if(parent[i[1]] == 0) {
                parent[i[1]] = i[0];
            }
            else {
                candidate2 = new int[]{i[0],i[1]};
                candidate1 = new int[]{parent[i[1]],i[1]};
                i[1] = 0;
            }
        }
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for(int[] i: edges) {
            if(i[1] == 0) continue;
            int p1 = find(i[0]);
            if(p1 == i[1]) {
                if(candidate1[0] == -1) return i;
                return candidate1;
            }
            parent[i[1]] = i[0];
        }
        return candidate2;
    }
    private int find(int node) {
        if(node == parent[node]) return node;
        return parent[node] = find(parent[node]);
    }
}