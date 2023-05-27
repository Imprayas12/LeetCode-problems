class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int n = height.length;
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int base = height[stack.peek()];
                stack.pop();
                if(stack.isEmpty()) break;
                int width = i - stack.peek() - 1;
                int len = Math.min(height[i], height[stack.peek()]) - base;
                ans += len * width;
            }
            stack.push(i);
        }
        return ans;
    }
}