// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        findSum(0,N,0,arr,ans);
        return ans;
    }
    private void findSum(int index,int N,int sum,ArrayList<Integer> arr,ArrayList<Integer> ans){
        if(index==arr.size()){
            ans.add(sum);
            return;
        }
        sum+=arr.get(index);
        findSum(index+1,N,sum,arr,ans);
        sum-=arr.get(index);
        findSum(index+1,N,sum,arr,ans);
    }
}