class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans,0,0,n,"");
        return ans;
    }
    private void helper(List<String> ans,int open_par,int close_par,int n,String str) {
        if(str.length() == n * 2) {
            ans.add(str);
            return;
        }       
        if(open_par < n) {
            helper(ans,open_par + 1,close_par,n,str + '(');
        }   
        if(close_par < open_par) {
            helper(ans,open_par,close_par + 1,n,str + ')');
        }
    }
}