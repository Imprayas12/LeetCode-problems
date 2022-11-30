class Solution {
    public int maximumScore(int[] nums, int k) {
        return Area(nums,k);   
    }
    private static int Area(int[] area,int k) {
        Stack<Integer> stack = new Stack<>();
        int max_area = 0;
        for (int i = 0; i < area.length; i++) {
            while (!stack.isEmpty() && area[i] < area[stack.peek()]) {
                int h = area[stack.pop()];
                int r = i;
                if(k < r)
                if (stack.isEmpty()) {
                    max_area = Math.max(max_area, h * r);
                } else {
                    int l = stack.peek();
                    if(k > l)
                    max_area = Math.max(max_area, h * (r - l - 1));
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int h = area[stack.pop()];
            int r = area.length;
            if(k < r)
            if(stack.isEmpty()) { 
                max_area = Math.max(max_area,h * r);
            } else {
                int l = stack.peek();
                if(k > l)
                max_area = Math.max(max_area,h * (r - l - 1));
                }
            }
        return max_area;
    }
}