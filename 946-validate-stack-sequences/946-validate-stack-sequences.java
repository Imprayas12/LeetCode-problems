class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int size = pushed.length;
        int pop =0;
        Stack<Integer> st = new Stack();
        for(int i=0;i<pushed.length;i++){
            st.push(pushed[i]);
            while(!st.isEmpty() && pop<size && st.peek()==popped[pop]){
                st.pop();
                pop++;
            }
        }
        return pop==size;
    }
}