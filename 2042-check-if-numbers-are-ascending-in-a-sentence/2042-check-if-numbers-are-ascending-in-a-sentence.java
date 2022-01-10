import java.util.*;

class Solution {
    public boolean areNumbersAscending(String s) {
        int f=-1;
        StringTokenizer st = new StringTokenizer(s," ");
        while(st.hasMoreTokens()){
            String sh = st.nextToken();
            if(Character.isDigit(sh.charAt(0)))
            {
                int a = Integer.parseInt(sh);
                if(f>=a) return false;
                f=a;
            }
        }
        return true;
    }
}