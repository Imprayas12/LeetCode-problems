class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        part(0,ans,s,new ArrayList<>());
        return ans;
    }
    private void part(int index, List<List<String>> ans, String s, List<String> current) {
        if(index == s.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s,index,i)) {
                current.add(s.substring(index,i + 1));
                part(i + 1,ans,s,current);
                current.remove(current.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s,int i,int j) {
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}