//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int v, List<List<Integer>> graph) {

        // Your code here
        int[] vis = new int[v];
        int[] pathVis = new int[v];
        int[] check = new int[v];
        for(int i = 0; i < v; i++) {
            if(vis[i] == 0) {
                dfsCheck(vis,pathVis,check,graph,i);
            }
        }
        List<Integer> ans = new LinkedList<>();
        for(int i = 0; i < v; i++) {
            if(check[i] == 1) ans.add(i);
        }
        return ans;
    }
    private boolean dfsCheck(int[] vis,int[] pathVis,int[] check,List<List<Integer>> graph,int node) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        for(var it: graph.get(node)) {
            if(vis[it] == 0) {
                if(dfsCheck(vis,pathVis,check,graph,it)) {
                    return true;
                } 
            }
            else if(pathVis[it] == 1){
                  return true;  
            }
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
}
