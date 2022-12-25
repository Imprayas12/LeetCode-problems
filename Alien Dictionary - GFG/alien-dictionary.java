//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    private int[] topoSort(int V,ArrayList<ArrayList<Integer>> adj) {
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
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
        int[] ans = new int[V];
        int k = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            ans[k++] = node;
            for(int i: adj.get(node)) {
                inDegree[i]--;
                if(inDegree[i] == 0) queue.add(i);
            }
        }
        return ans;
    }
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }
        for(int j = 0; j < N - 1; j++) {
            String str1 = dict[j];
            String str2 = dict[j + 1];
            for(int i = 0; i < Math.min(str1.length(),str2.length()); i++) {
                if(str1.charAt(i) != str2.charAt(i)) {
                    adj.get(str1.charAt(i) - 'a').add(str2.charAt(i) - 'a');
                    break;
                }
            }
        }
        int[] ans = topoSort(K,adj);
        String ret = "";
        for(int i: ans) {
            ret += (char)(97 + i);
        }
        return ret;
    }
}