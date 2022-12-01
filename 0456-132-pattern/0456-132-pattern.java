class Solution {
    public boolean find132pattern(int[] arr) {
        int[] min = new int[arr.length];
        min[0] = arr[0];
        for (int i = 1; i < min.length; i++) {
            min[i] = Math.min(min[i - 1],arr[i]);
        }
        Stack<Integer> stack = new Stack<>();  
        for(int j = arr.length - 1; j >= 0; j--) {
            int i_th = min[j];
            while (!stack.isEmpty() && i_th >= arr[stack.peek()]) stack.pop();
            if(!stack.isEmpty() && arr[j] > arr[stack.peek()]) return true;
            stack.push(j);
        }
        return false;
    }
}