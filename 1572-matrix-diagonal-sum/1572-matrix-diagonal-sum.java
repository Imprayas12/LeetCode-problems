class Solution {
    public int diagonalSum(int[][] mat) {
        int s1 = 0;
        for(int i = 0; i < mat.length; i++) s1 += mat[i][i];
        int s2 = 0;
        for(int i = 0, j = mat.length - 1; i < mat.length && j >= 0; i++, j--) 
            s2 += mat[i][j];
        if(mat.length % 2 == 1)
        return s1 + s2 - mat[mat.length/2][mat.length/2];
        return s1 + s2;
    }
}