//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		long t=sc.nextLong();
		
		while(t-->0)
		{
		  int n=sc.nextInt();
		  long arr[]=new long[n];
		  long brr[]=new long[n];
		  
		  for(int i=0;i<n;i++)
		  {
		      arr[i]=sc.nextLong();
		  }
		  
		  for(int i=0;i<n;i++)
		  {
		      brr[i]=sc.nextLong();
		  }
		  Solution ob = new Solution();
		  System.out.println(ob.check(arr,brr,n)==true?"1":"0");
		  
		  
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to check if two arrays are equal or not.
    public static boolean check(long A[],long B[],int N)
    {
        //Your code here
        Map<Long,Long> map1 = new HashMap<>();
        Map<Long,Long> map2 = new HashMap<>();
        for(int i = 0; i < N; i++) {
            map1.put(A[i],map1.getOrDefault(A[i],(long)0) + 1);
            map2.put(B[i],map2.getOrDefault(B[i],(long)0) + 1);
        }
        for(Map.Entry<Long,Long> m: map1.entrySet()) {
            long k = m.getKey();
            long v = m.getValue();
            if(map2.containsKey(k)) {
                if(map2.get(k) != v) return false;
            }
            else return false;
        }
        return true;
    }
}