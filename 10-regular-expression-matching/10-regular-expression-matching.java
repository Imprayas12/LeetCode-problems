import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile("("+p+")");
        Matcher match = pattern.matcher(s);
        if(match.find() && match.group(0)==s)return true;
        return false;
    }
}