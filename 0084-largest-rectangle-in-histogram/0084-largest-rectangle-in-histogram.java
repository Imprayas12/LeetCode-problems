class Solution {
    public int largestRectangleArea(int[] heights) {
        return Area(heights);
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