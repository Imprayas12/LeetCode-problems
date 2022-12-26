class Solution {
    public int minJumps(int[] arr) {
        if(arr.length == 1) return 0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], x -> new ArrayList()).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int ans = 0;
        boolean vis[] = new boolean[arr.length];
        vis[0] = true;
        while(!queue.isEmpty()) {
            for(int s = queue.size(); s > 0; --s) {
            int node = queue.poll();
            if(node == arr.length - 1) return ans;
            var indices = map.get(arr[node]);
            indices.add(node - 1);
            indices.add(node + 1);
            for(int i : indices) {
                if(i >= 0 && i < arr.length && !vis[i]) {
                    vis[i] = true;
                    queue.add(i);
                    }
                }
                indices.clear();
            }
            ans++;
        }
        return 0;
        // return jumps(arr,map,0,new boolean[arr.length],0);
    }
    private int jumps(int[] arr,Map<Integer,Set<Integer>> map,int idx,boolean[] vis,int count) {
        if(idx == arr.length - 1) return count;
        if(vis[idx]) return Integer.MAX_VALUE;
        vis[idx] = true;
        int ans = Integer.MAX_VALUE;
        Set<Integer> idxs = map.get(arr[idx]);
        if(idxs.size() > 1) {
            for(int i: idxs) {
                if(i != idx) {
                    ans = Math.min(ans,jumps(arr,map,i,vis,count + 1));
                }
            }
        }
        vis[idx] = false;
        return ans;
    }
}