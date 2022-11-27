class Solution {
    public boolean isNumber(String s) {
        if(s.length() == 0 || s.trim().length() == 0) return false;
        s = s.trim();
        boolean numberApp = false;
        boolean dotApp = false;
        boolean eApp = false;
        boolean numAfterE = false;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numberApp = true;
                numAfterE = true;
            }
            else if(s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if(eApp || !numberApp) return false;
                eApp = true;
                numAfterE = false;
            }
            else if(s.charAt(i) == '.') {
                if(eApp || dotApp) return false;
                dotApp = true;
            }
            else if(s.charAt(i) == '+' || s.charAt(i) == '-') {
                if(i != 0 && s.charAt(i - 1) != 'e') return false;
            }
            else return false;
        }
        return numberApp && numAfterE;
    }
}