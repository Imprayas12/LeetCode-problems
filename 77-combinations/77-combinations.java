class Solution {
    public List<List<Integer>> combine(int n, int k) {
        Set<List<Integer>> set = new HashSet<>();
        int c = k;
        for(int i = 1; i <= n; i++){
        recur(i,set,new HashSet<>(),k,n,c);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(var i: set) {
            var cur = List.copyOf(i);
            ans.add(cur);
        }
        return ans;
    }
    private void recur(int ind,Set<List<Integer>> ans, Set<Integer> cur,int k, int n,int c) {
        if(k == 0) {
            if(cur.size() == c) {
            List<Integer> list = new ArrayList<>(cur);
            Collections.sort(list);
            ans.add(list);
            }
            return;
        }
        for(int i = ind; i <= n; i++){
            cur.add(i);
            recur(i + 1,ans,cur,k - 1,n,c);
            cur.remove(i);
        }
    }
}