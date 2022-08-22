class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2) return true;
        for(int i = 1; i < coordinates.length - 1; i++){
            double nr1 = ((double)coordinates[i][1] - (double)coordinates[i-1][1]);
            double dr1 = ((double)coordinates[i][0] - (double)coordinates[i-1][0]);
            
            double nr2 = ((double)coordinates[i + 1][1] - (double)coordinates[i][1]);
            double dr2 = ((double)coordinates[i + 1][0] - (double)coordinates[i][0]);
            if(nr1 * dr2 != nr2 * dr1) return false;
        }
        return true;
    }
}