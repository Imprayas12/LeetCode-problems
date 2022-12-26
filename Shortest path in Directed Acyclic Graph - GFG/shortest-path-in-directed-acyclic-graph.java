//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    class Pair {
        int node;
        int weight;
        Pair(int node,int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    private void topoSort(int[] vis,Stack<Integer> stack,ArrayList<ArrayList<Pair>> adj,int node) {
        vis[node] = 1;
        for(Pair i: adj.get(node)) {
            int curNode = i.node;
            if(vis[curNode] == 0) {
                topoSort(vis,stack,adj,curNode);
            }
        }
        stack.push(node);
    }
	public int[] shortestPath(int n,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i = 0; i < n; i++) {
		    adj.add(new ArrayList<Pair>());
		}
		for(int i = 0; i < edges.length; i++) {
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int weight = edges[i][2];
		    adj.get(u).add(new Pair(v,weight));
		}
		Stack<Integer> stack = new Stack<>();
		int[] vis = new int[n];
		for(int i = 0; i < n; i++) {
		    if(vis[i] == 0) topoSort(vis,stack,adj,i);
		}
		int[] dist = new int[n];
		Arrays.fill(dist,999999);
		dist[0] = 0;
		while(!stack.isEmpty()) {
		    int node = stack.pop();
		    for(Pair i: adj.get(node)) {
		        int v = i.node;
		        int wt = i.weight;
		        if(dist[node] + wt < dist[v]) {
		            dist[v] = dist[node] + wt;
		        }
		    }
		}
		for(int i = 0; i < n; i++) {
		    if(dist[i] == 999999) dist[i] = -1;
		}
		return dist;
	}
}