class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int[] i: prerequisites) {
            graph.get(i[0]).add(i[1]);
        }
        int[] indegree = new int[n];
        for(var i: graph) {
            for(int j: i) {
                indegree[j]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) queue.add(i);
        }
        int k = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            k++;
            for(int i: graph.get(node)) {
                indegree[i] -= 1;
                if(indegree[i] == 0) queue.add(i);
            }
        }
        return k == n;
    }
}