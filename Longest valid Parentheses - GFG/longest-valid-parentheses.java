// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String str){
        // code here
        int arr[]=new int[str.length()];//stores the longest valid parentheses till ith index
        Stack<Integer>myst=new Stack<Integer>();
        int ans=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(')
                myst.push(i);
            else if(myst.size()>0){
                if(myst.peek()>0)
                    arr[i]=i-myst.peek()+1+arr[myst.peek()-1];
                else
                    arr[i]=i+1;
                ans=Math.max(arr[i],ans);
                myst.pop();
            }
        }
        return(ans);
    }
}