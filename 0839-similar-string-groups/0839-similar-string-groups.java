class Solution {
    int[] parent;
    int[] rank;
    public int numSimilarGroups(String[] strs) {
        parent = new int[strs.length];
        rank = new int[strs.length];
        for(int i = 0; i < strs.length; i++) parent[i] = i;
        int n = strs.length;
        int count = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(strs[i], strs[j]) && find(i) != find(j)) {
                    count--;
                    union(i, j);
                }
            }
        }
        return count;
    }
    private int find(int num) {
        if(parent[num] == num) return parent[num];
        return parent[num] = find(parent[num]);
    }
    private void union(int x, int y) {
        int par1 = find(x);
        int par2 = find(y);
        if(par1 == par2) return;
        if(rank[par1] < rank[par2]) {
            parent[par1] = par2;
        }
        else if(rank[par1] > rank[par2]) {
            parent[par2]  = par1;
        }
        else {
            parent[par2] = par1;
            rank[par1] += 1;
        }
    }
    private boolean check(String s1, String s2) {
        int changes = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) changes += 1;
            if(changes > 2) return false;
        }
        return changes == 0 || changes == 2;
    }
}