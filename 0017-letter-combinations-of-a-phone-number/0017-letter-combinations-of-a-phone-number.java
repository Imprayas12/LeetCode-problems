class Solution {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if(n == 0) return new ArrayList<>();
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        
        List<String> ans = new ArrayList<>();
        recur("",digits,ans,0,map,n);
        return ans;
        
    }
    private void recur(String cur,String str,List<String> ans,int ind,Map<Integer,String> map, int n) {
        if(ind == n) {
            ans.add(cur);
            return;
        }
        String curStr = map.get(str.charAt(ind)-'0');
        for(int i = 0; i < curStr.length(); i++) {
            recur(cur + curStr.charAt(i),str,ans,ind + 1,map,n);
        }
    }
}