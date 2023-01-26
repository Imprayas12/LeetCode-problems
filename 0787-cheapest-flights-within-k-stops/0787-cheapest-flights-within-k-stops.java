class Solution {
    class Pair {
        int node;
        int dist;
        Pair(int node,int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Pair>[] graph = new List[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] i: flights) {
            graph[i[0]].add(new Pair(i[1],i[2]));
            // graph[i[0]].add(graph[i[2]]);
        }
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(src,0));
        int stops = 0;
        while(stops <= k && !queue.isEmpty()) {
            int size = queue.size();
            while(size-->0) {
                Pair currentStop = queue.poll();
                int node = currentStop.node;
                int distance = currentStop.dist;
                // if(graph[node].size() == 0) continue;
                for(Pair pair: graph[node]) {
                    int neighbour = pair.node;
                    int cost = pair.dist;
                    if(distance + cost < dist[neighbour]) {
                        dist[neighbour] = distance + cost;
                        queue.add(new Pair(neighbour,dist[neighbour]));
                    }
                }
            }
            stops++; 
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}