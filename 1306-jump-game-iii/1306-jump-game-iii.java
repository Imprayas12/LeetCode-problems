class Solution {
    public boolean canReach(int[] arr, int start) {
        if(arr[start] == 0) return true;
        boolean[] vis = new boolean[arr.length];
        return bfs(arr,start,vis);
    }
    private boolean bfs(int[] arr,int idx,boolean[] vis) {
        if(arr[idx] == 0) return true;
        if(vis[idx]) return false;
        vis[idx] = true;
        boolean ans = false;
        if(idx + arr[idx] < arr.length) {
            ans = ans || bfs(arr,idx + arr[idx],vis);
        } 
        if(ans) return true;
        if(idx - arr[idx] >= 0) {
            ans = ans || bfs(arr,idx - arr[idx],vis);
        }
        vis[idx] = false;
        return ans;
    }
}