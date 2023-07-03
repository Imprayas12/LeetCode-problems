class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        if(s.equals(goal)) {
            int[] frequency = new int[26];
            for (char ch : s.toCharArray()) {
                frequency[ch - 'a'] += 1;
                if (frequency[ch - 'a'] == 2) {
                    return true;
                }
            }
            return false;
        }
        int n = s.length();
        List<Integer> indices = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                indices.add(i);
            }
        }
        if(indices.size() != 2) return false;
        int idx1 = indices.get(0);
        int idx2 = indices.get(1);
        return s.charAt(idx1) == goal.charAt(idx2) && s.charAt(idx2) == goal.charAt(idx1);
        
    }
}