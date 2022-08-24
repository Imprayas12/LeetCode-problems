class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] vis = new int[isConnected.length];
        int count = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(vis[i] != 1) {
                vis[i] = 1;
                count += 1;
                dfs(vis,isConnected,i);
            }
        }
        return count;
    }
    private void dfs(int[] vis,int[][] isConnected,int node) {
        for(int i = 0; i < isConnected[node].length; i++) {
            if(isConnected[node][i] == 1 && vis[i] != 1) {
                vis[i] = 1;
                dfs(vis,isConnected,i);
            }
        }
    }
}