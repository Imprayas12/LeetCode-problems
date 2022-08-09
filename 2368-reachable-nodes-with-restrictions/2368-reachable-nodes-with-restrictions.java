class Solution {
    static int ans = 0;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> restrict = new HashSet<>();
        for(int i: restricted) restrict.add(i);
        Set<Integer> vis  = new HashSet();
        Map<Integer,List<Integer>> graph = new HashMap();
        for(int i = 0; i < n - 1; i++){
            var list1 = graph.getOrDefault(edges[i][0], new ArrayList<>());
            list1.add(edges[i][1]);
            graph.put(edges[i][0],list1);
            var list2 = graph.getOrDefault(edges[i][1],new ArrayList<>());
            list2.add(edges[i][0]);
            graph.put(edges[i][1],list2);
        }
        for(int i = 0; i < graph.get(0).size(); i++){
            int curNode = graph.get(0).get(i);    
            if(!restrict.contains(curNode) && !vis.contains(curNode))
                {   vis.add(curNode);
                    ans += 1;
                    search(ans,curNode,graph,vis,restrict,n);
                }
            }
        if(vis.size() == 0) return 1;
        return vis.size();
    }
    public void search(int ans, int col,Map<Integer,List<Integer>> graph,Set<Integer> vis,Set<Integer> restrict,int n){
        for(int i = 0; i < graph.get(col).size(); i++){
            int curNode = graph.get(col).get(i);
            if(!restrict.contains(curNode) && !vis.contains(curNode)){
                    ans += 1;
                    vis.add(curNode);
                    search(ans,curNode,graph,vis,restrict,n);
            }
    }
}
}