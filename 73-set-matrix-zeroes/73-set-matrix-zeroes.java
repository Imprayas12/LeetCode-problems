class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ind = -1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==0){
                    ind = i-1;
                    while(ind>=0){
                        if(matrix[ind][j]!=0)
                        matrix[ind][j]=Integer.MIN_VALUE+1;
                        ind--;
                    }
                    ind = i + 1;
                    while(ind<rows){
                        if(matrix[ind][j]!=0)
                        matrix[ind][j]=Integer.MIN_VALUE+1;
                        ind++;
                    }
                    ind = j -1;
                    while(ind>=0){
                        if(matrix[i][ind]!=0)
                        matrix[i][ind]=Integer.MIN_VALUE+1;
                        ind--;
                    }
                    ind = j+1;
                    while(ind<cols){
                        if(matrix[i][ind]!=0)
                        matrix[i][ind]=Integer.MIN_VALUE+1;
                        ind++;
                    }
                }
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==Integer.MIN_VALUE+1)
                    matrix[i][j]=0;
            }
        }
    }
}