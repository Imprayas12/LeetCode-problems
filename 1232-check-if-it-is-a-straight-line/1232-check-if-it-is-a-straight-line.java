class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2) return true;
        for(int i = 1; i < coordinates.length - 1; i++){
            if(((double)coordinates[i][1] - (double)coordinates[i-1][1]) * ((double)coordinates[i + 1][0] - (double)coordinates[i][0]) !=  ((double)coordinates[i + 1][1] - (double)coordinates[i][1]) * ((double)coordinates[i][0] - (double)coordinates[i-1][0])) return false;
        }
        return true;
    }
}