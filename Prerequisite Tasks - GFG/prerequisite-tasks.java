//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int V, int[][] preReq)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(var i: preReq) {
            adj.get(i[0]).add(i[1]);
        }
        int[] inDegree = new int[V];
        for(var i: adj) {
            for(var j: i) {
                inDegree[j]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < V; i++) {
            if(inDegree[i] == 0) queue.add(i);
        }
        int k = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            k++;
            for(int i: adj.get(node)) {
                inDegree[i]--;
                if(inDegree[i] == 0) queue.add(i);
            }
        }
        return k == V;
    }
    
}