//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class Pair {
        int node;
        int dist;
        Pair(int node,int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>()); 
        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        int[] dis = new int[n + 1];
        Arrays.fill(dis,999999);
        dis[1] = 0;
        int[] parent = new int[n + 1];
        for(int i = 0; i < parent.length; i++) parent[i] = i;
        pq.add(new Pair(1,0));
        while(!pq.isEmpty()) {
            int node = pq.peek().node;
            int dist = pq.peek().dist;
            pq.poll();
            for(var it: adj.get(node)) {
                int sideNode = it.node;
                int edgeWeight = it.dist;
                if(dist + edgeWeight < dis[sideNode]) {
                    dis[sideNode] = dist + edgeWeight;
                    pq.add(new Pair(sideNode,dis[sideNode]));
                    parent[sideNode] = node;
                }
            }
        }
        List<Integer> ans = new ArrayList<>(); 
        if(dis[n] == 999999) {
            ans.add(-1);
            return ans;
        }
        int node = n;
        while(parent[node] != node) {
            ans.add(node);
            node = parent[node];
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }
}