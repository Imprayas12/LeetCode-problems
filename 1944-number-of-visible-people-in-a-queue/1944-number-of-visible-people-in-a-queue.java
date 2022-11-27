class Solution {
    public int[] canSeePersonsCount(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[i] >= stack.peek()) {
                ans[i] += 1;   
                stack.pop();
            }
            if(!stack.isEmpty()) ans[i] += 1;
            stack.push(arr[i]);
        }
        // System.out.println(stack);
        return ans;
    }
}