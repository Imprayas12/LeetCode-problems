class Solution {
    public int equalPairs(int[][] grid) {
    int n = grid.length;
    long[] rowDigits = new long[n];
    long[] colDigits = new long[n];

    for(int i = 0; i < n; i++){
        long sum = 0;
        for(int j = 0; j < n; j++){
            sum = sum*10 + grid[i][j];
        }
        rowDigits[i] = sum; 
    }
    for(int i = 0; i < n; i++){
        long sum = 0;
        for(int j = 0; j < n; j++){
            sum = sum*10 + grid[j][i];
        }
        colDigits[i] = sum; 
    }
    int count = 0;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            count += rowDigits[i] == colDigits[j] ? 1 : 0;
        }
    }
    return count;
}
}