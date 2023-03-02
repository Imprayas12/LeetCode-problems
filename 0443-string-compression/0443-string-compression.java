class Solution {
    public int compress(char[] chars) {
        String ans = "";
        int i = 0;
        while(i < chars.length) {
            char ch = chars[i];
            i += 1;
            int count = 1;
            while(i < chars.length && chars[i] == ch) {
                i++;
                count++;
            }
            ans += ch;
            if(count > 1)
            ans += count;
        }
        for(i = 0; i < ans.length(); i++) {
            chars[i] = ans.charAt(i);
        }
        return ans.length();
    }
}