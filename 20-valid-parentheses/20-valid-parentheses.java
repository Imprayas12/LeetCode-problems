import java.util.*;

class Solution {
    public boolean isValid(String s) {
      Stack<Character> S = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='(' || ch == '{' || ch == '[')
                S.push(ch);
            else{
                if(S.isEmpty()) return false;
                else{
                    char ch2 = S.pop();
                    if((ch=='}' && ch2 !='{' )||(ch==']' && ch2 !='[')||(ch==')' && ch2!='(') ) return false;
                }
            }
        }
        return S.isEmpty();  
    }
}