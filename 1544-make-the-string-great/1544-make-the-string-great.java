class Solution {
    public String makeGood(String s) {
        if(s.length() == 0 || s.length() == 1) return s;
        Stack<Character> stack = new Stack<>();
        String ans = "";
        for(int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if(!stack.isEmpty()) {
                if(stack.peek() == Character.toUpperCase(curChar) && Character.isLowerCase(curChar)|| stack.peek() == Character.toLowerCase(curChar) && Character.isUpperCase(curChar)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(curChar);
        }
        while(!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}