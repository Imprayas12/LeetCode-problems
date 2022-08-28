class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < col; i++) {
            int[] sum = new int[row];
            for(int j = i; j < col; j++){
                int kad = 0; int maxK = Integer.MIN_VALUE;
                for(int r = 0; r < row; r++){
                    sum[r] += matrix[r][j];
                    kad = Math.max(sum[r] + kad,sum[r]);
                    maxK = Integer.max(maxK,kad);
                }
                if(maxK <= k) {
                    ans = Math.max(ans, maxK);
                    continue;
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int cur = 0;
                // int Max = Integer.MIN_VALUE;
                for(int r = 0; r < row; r++){
                    cur += sum[r];
                    Integer t = set.ceiling(cur - k);
                    if(t != null) ans = Math.max(ans,cur - t);
                    set.add(cur);
                }
            }
        }
        return ans;
    }
}