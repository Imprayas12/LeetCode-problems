//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int height[], int n) { 
        // Your code here
        int[] dp1 = new int[n];
        dp1[0] = height[0];
        for(int i=1;i<n;i++){
            dp1[i]=Math.max(dp1[i-1],height[i]);
        }
        int[] dp2 = new int[n];
        dp2[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            dp2[i]=Math.max(dp2[i+1],height[i]);
        }
        long ans =0;
        for(int i=0;i<n;i++){
            ans+=Math.min(dp1[i],dp2[i])-height[i];
        }
        return ans;
    } 
}


