class Solution {
    int num = 0;
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList();
        greyCode(n,ans);  
        return ans;
    }
    private void greyCode(int n, List<Integer> ans) {
        if(n == 0) {
            ans.add(num);
            return;
        }
        else {
            greyCode(n - 1, ans);
            num ^= (1 << n - 1);
            greyCode(n - 1, ans);
        }
    }
}