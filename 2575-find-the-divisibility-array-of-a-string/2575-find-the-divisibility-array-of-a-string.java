class Solution {
    public int[] divisibilityArray(String word, int m) {
        int[] ans = new int[word.length()];
        long number = 0l;
        for(int i = 0; i < word.length(); i++) {
            number = number * 10l + (long) word.charAt(i) - '0';
            number = number % m;
            if(number == 0) ans[i] = 1;
        }
        return ans;
    }
}