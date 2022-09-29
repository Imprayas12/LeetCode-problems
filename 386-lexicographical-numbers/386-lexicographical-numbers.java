class Solution {
    public List<Integer> lexicalOrder(int n) {
        Set<Integer> count = new LinkedHashSet<>();
        for(int i = 1; i <= n; i++)
        counting(i,n,count);
        List<Integer> ans = new ArrayList<>(count);
        return ans;
    }
    private void counting(int num,int n,Set<Integer> ans) {
        if(num > n)
            return;
         ans.add(num);
        for (int i = 0; i < 10; i++) {
            counting(num * 10 + i,n,ans);
        }
    }
}