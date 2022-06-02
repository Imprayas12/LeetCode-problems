class Solution {
    public int longestValidParentheses(String str) {
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
        return ans;
    }
}