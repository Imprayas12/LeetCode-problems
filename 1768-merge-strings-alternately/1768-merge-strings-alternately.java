class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder("");
        int n = word1.length();
        int m = word2.length();
        int loop = Math.min(n, m);
        int i = 0;
        for(i = 0; i < loop; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        while(i < n) sb.append(word1.charAt(i++));
        while(i < m) sb.append(word2.charAt(i++));
        return sb.toString();
    }
}