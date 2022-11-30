class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] counts = new int[matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length;j++) {
                if(matrix[i][j] == '0') counts[j] = 0;
                else counts[j] += 1;
            }
            max = Math.max(Area(counts),max);
        }
       return max;
    }
    private static int Area(int[] area) {
        Stack<Integer> stack = new Stack<>();
        int max_area = 0;
        for (int i = 0; i < area.length; i++) {
            while (!stack.isEmpty() && area[i] < area[stack.peek()]) {
                int h = area[stack.pop()];
                int r = i;
                if (stack.isEmpty()) {
                    max_area = Math.max(max_area, h * r);
                } else {
                    int l = stack.peek();
                    max_area = Math.max(max_area, h * (r - l - 1));
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int h = area[stack.pop()];
            int r = area.length;
            if(stack.isEmpty()) {
                max_area = Math.max(max_area,h * r);
            } else {
                int l = stack.peek();
                max_area = Math.max(max_area,h * (r - l - 1));
                }
            }
        return max_area;
    }
}