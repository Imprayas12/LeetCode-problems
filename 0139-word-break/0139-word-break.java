class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
    private boolean helper(int index, String sub, Set<String> set, String s, Set<String> segments) {
        if(index == s.length()) {
            for(String t: segments) {
                System.out.println(t);
                if(!set.contains(t)) return false;
            }
            return true;
        }
        //include current char 
       boolean ans1 = helper(index + 1, sub + s.charAt(index), set, s, segments);
        //Don't include current char
       if(sub.length() != 0) segments.add(sub);
       boolean ans2 =helper(index + 1, "", set, s, segments);
        segments.remove(sub);
        return ans1 || ans2;
    }
    
}