class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        helper(ans,"",0,s);
        return ans;
    }
    private void helper(List<String> ans,String cur,int i,String s) {
        if(i == s.length()) {
            ans.add(cur);
            return;
        }
        if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
            helper(ans,cur + (char)(s.charAt(i) + 32),i + 1,s);
        }
        if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
            helper(ans,cur + (char)(s.charAt(i) - 32),i + 1,s);
        }
        helper(ans,cur + (char)s.charAt(i),i + 1,s);
    }
}