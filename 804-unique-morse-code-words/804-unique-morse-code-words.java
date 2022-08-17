class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morses = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(int i = 0; i < words.length; i++){
            StringBuilder temp = new StringBuilder("");
            for(int j = 0; j < words[i].length();j++){
                temp.append(morses[words[i].charAt(j) - 'a']);
            }
            set.add(temp.toString());
        }
        return set.size();
    }
}