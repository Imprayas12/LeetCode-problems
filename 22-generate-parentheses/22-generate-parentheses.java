class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans,n,0,0,new StringBuilder());
        return ans;
    }
    private void helper(List<String> ans,int n,int open_par,int close_par, StringBuilder str){
        if(str.length()==n*2){
            ans.add(str.toString());
            return;
        }
        if(open_par<n){
            str.append("(");
            helper(ans,n,open_par+1,close_par,str);
            str.deleteCharAt(str.length()-1);
        }
        if(close_par < open_par){
            str.append(")");
            helper(ans,n,open_par,close_par+1,str);
            str.deleteCharAt(str.length()-1);
        }
    }
}