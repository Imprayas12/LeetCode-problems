class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else {
                if(stack.size() > 0) 
                    stack.pop();
            }
        }
        return (stack.size() + 1)/2;
    }
}