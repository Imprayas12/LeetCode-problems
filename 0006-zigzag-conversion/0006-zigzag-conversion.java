class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int n = s.length();
        int sections = (int) Math.ceil(n / (2 * numRows - 2.0));
        int numCols = sections * (numRows - 1);
        char[][] convert = new char[numRows][numCols];
        for(char[] i: convert) Arrays.fill(i,' ');
        int row = 0;
        int col = 0;
        int idx = 0;
        while(idx < n) {
            while(row < numRows && idx < n) {
                convert[row][col] = s.charAt(idx++);
                row++;
            }
            row -= 2;
            col += 1;
            while(row > 0 && col < numCols && idx < n) {
                convert[row][col] = s.charAt(idx++);
                row--;
                col++;
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(char[] i: convert) {
            for(char j: i) {
                if(j != ' ') sb.append(j);
            }
        }
        return sb.toString();
    }
}