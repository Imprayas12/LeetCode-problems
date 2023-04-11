class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder("");
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*') {
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(s.charAt(i));
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}