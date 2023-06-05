class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans = new int[A.length];
        ans[0] = A[0] == B[0] ? 1 : 0;
        ans[A.length - 1] = A.length;
        Set<Integer> setA = new HashSet<>();
        setA.add(A[0]);
        Set<Integer> setB = new HashSet<>();
        setB.add(B[0]);
        for(int i = 1; i < A.length - 1; i++) {
            if(A[i] == B[i]) {
                ans[i] = ans[i - 1] + 1;
            }
            else {
                setA.add(A[i]);
                setB.add(B[i]);
                if(setA.contains(B[i]) && setB.contains(A[i])) {
                    ans[i] = ans[i - 1] + 2;
                }
                else if(setA.contains(B[i]) || setB.contains(A[i]))
                    ans[i] = ans[i - 1] + 1;
                else ans[i] = ans[i - 1];
            }
        }
        return ans;
    }
}