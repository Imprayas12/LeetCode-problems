class Solution {
      public boolean searchMatrix(int[][] matrix, int target) {
        int inLow, inHi;
        int outLow, outHi;
        for(int i=0;i< matrix.length;i++){
            inLow = 0;
            inHi = matrix[i].length-1;
            while(inLow<=inHi){
                int mid = inLow+(inHi-inLow)/2;
                if(matrix[i][mid]==target)
                    return true;
                else if(matrix[i][mid]>target)
                    inHi = mid -1;
                else
                    inLow = mid+1;
            }
        }
        return false;
    }  
}