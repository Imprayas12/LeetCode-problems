class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int[] freq_1 = new int[26];
        int[] freq_2 = new int[26];
        for(int i = 0; i < word1.length(); i++) {
            freq_1[word1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < word2.length(); i++) {
            freq_2[word2.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(freq_1[i] == freq_2[i]) continue;
            if(freq_1[i] == 0 || freq_2[i] == 0) return false;
        }
        Arrays.sort(freq_1);
        Arrays.sort(freq_2);
        for(int i = 0; i < 26; i++) {
            if(freq_1[i] != freq_2[i]) return false;
        }
        return true;
    }
}