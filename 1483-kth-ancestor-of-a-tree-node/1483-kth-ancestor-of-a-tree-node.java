class TreeAncestor {
    int height;
    int jumps[][];
    public TreeAncestor(int n, int[] parent) {
        //Height of the tree has to be more than k'th ancestor always
        this.height = (int)(Math.log(n)/ Math.log(2)) + 1;
        jumps = new int[height][n];
        jumps[0] = parent;
        for(int i = 1; i < height; i++) {
            for(int j = 0; j < n; j++) {
                int pre = jumps[i - 1][j];
                jumps[i][j] = pre == -1 ? -1 : jumps[i - 1][pre];
            }
        }
    }
    public int getKthAncestor(int node, int k) {
        int height = this.height;
        while(k > 0 && node > - 1) {
            if(k >= 1 << height) {
                node = jumps[height][node];
                k -= 1 << height;
            }
            else height -= 1;
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */