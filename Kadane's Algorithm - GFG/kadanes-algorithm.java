// { Driver Code Starts
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling maxSubarraySum() function
		    System.out.println(obj.maxSubarraySum(arr, n));
		}
	}
}

// } Driver Code Ends


class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n){
        
        // Your code here
        long max_so_far      = Integer.MIN_VALUE;
        long max_ending_here = 0;
        long max_element     = Integer.MIN_VALUE;

for (int i = 0; i <arr.length; i++)
{
    max_ending_here = Math.max(max_ending_here + arr[i], 0);
    max_so_far      = Math.max(max_ending_here, max_so_far);
    max_element     = Math.max(max_element, arr[i]);
}

    if (max_so_far == 0)
    max_so_far = max_element;
return max_so_far;
    }
    
}

