import java.util.*;

class Solution {
    public String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s," ");
        String s1 = ""; 
        Stack<String> stack = new Stack<>();
        while(st.hasMoreTokens()) {
            stack.add(st.nextToken());
        }
        while(!stack.isEmpty()) {
            s1 += stack.pop();
            s1 += " ";
        }
        return s1.trim();
    }
}