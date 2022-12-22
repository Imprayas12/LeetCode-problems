//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>graph)
    {
        // Code here
        
        int[] colors = new int[v];
        Arrays.fill(colors,-1);
        for(int i = 0; i < v; i++) {
            if(colors[i] == -1) {
                if(!check(colors,graph,i,v)) return false; 
            }
        }
        return true;
    }
    private boolean check(int[] colors,ArrayList<ArrayList<Integer>>graph,int vertex,int V) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(vertex);
        while(!queue.isEmpty()) {
            int vt = queue.poll();
            for(int node: graph.get(vt)) {
                if(colors[node] == -1) {
                    colors[node] = ~colors[vt];
                    queue.add(node);
                }
                else if(colors[node] == colors[vt]) return false;
            }
        }
        return true;
    }
}