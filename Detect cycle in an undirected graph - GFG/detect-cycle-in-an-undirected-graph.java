//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    class Pair {
        int x;
        int y;
        Pair(int x,int y) {this.x = x; this.y = y;}
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        for(int i = 0; i < adj.size(); i++) {
            if(!vis[i]) {
                if(dfs(i,-1,adj,vis)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,boolean[] vis) {
        vis[node] = true;
        for(var adjNode: adj.get(node)) {
            if(!vis[adjNode]) {
                if(dfs(adjNode,node,adj,vis) == true) return true;
            }
            else if(adjNode != parent){
                return true;
            }
        }
        return false;
    }
    private boolean checkCycle(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int src) {
        Queue<Pair> queue = new LinkedList<>();
        vis[src] = true;
        queue.add(new Pair(src,-1));
        while(!queue.isEmpty()) {
            int node = queue.peek().x;
            int parent = queue.peek().y;
            queue.poll();
            for(var neighbouringNode: adj.get(node)) {
                if(!vis[neighbouringNode]) {
                    vis[neighbouringNode] = true;
                    queue.add(new Pair(neighbouringNode,node));
                }
                else if(parent != neighbouringNode) {
                    return true;
                }
            }
        }
        return false;
    }
}