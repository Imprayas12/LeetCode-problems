class Solution {
public:
    int diagonalSum(vector<vector<int>>& mat) {
        int s1 = 0;
        for(int i = 0; i < mat.size(); i++) s1 += mat[i][i];
        for(int i = mat.size() - 1, j = 0; i >= 0 && j < mat.size(); i--,j++) s1 += mat[j][i];
        return mat.size() % 2 == 1 ? s1 - mat[mat.size()/2][mat.size()/2] : s1;
    }
};