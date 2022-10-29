//{ Driver Code Starts
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
        int slow = 0;
        int fast = 0;
        int curSum = 0;
        int maxSum = 0;
        int maxEle = Integer.MIN_VALUE;
        while(fast < n) {
            curSum += arr[fast];
            if(curSum > maxSum) maxSum = curSum;
            else if(curSum < 0) curSum = 0;
            maxEle = Math.max(arr[fast++],maxEle);
        }
        return maxSum == 0 ? maxEle : maxSum;
    }
    
}

