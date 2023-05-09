class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = 0;
        int max_row = matrix.length - 1;
        int col = 0;
        int max_col = matrix[0].length - 1;
        int count = 0;
        int t = matrix[0].length * matrix.length;
        while(count != matrix[0].length * matrix.length){
        for(int i = col; i <= max_col && count < t; i++){
            list.add(matrix[row][i]);
            count++;
        }
        row++;
        for(int i = row; i <= max_row && count < t; i++){
            list.add(matrix[i][max_col]);
            count++;
        }  
        max_col--;
        for(int i = max_col; i >= col && count < t; i--){
            list.add(matrix[max_row][i]);
                        count++;

        }
        max_row--;
        for(int i = max_row; i>= row && count < t; i--) {
            list.add(matrix[i][col]);
            count++;

        }
        col++;
        }
        // List<Integer> ans = new ArrayList<>(list);
        return list;
    }
}