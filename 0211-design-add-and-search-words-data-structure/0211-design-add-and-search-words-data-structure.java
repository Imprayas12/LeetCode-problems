class WordDictionary {
    class Trie {
        Trie[] links = new Trie[26];
        boolean wordEndingHere = false;
    }
    Trie trie_root;
    public WordDictionary() {
        trie_root = new Trie();
    }
    
    public void addWord(String word) {
        Trie root = trie_root;
        for(int i = 0; i < word.length(); i++) {
            if(root.links[word.charAt(i) - 'a'] == null) {
                root.links[word.charAt(i) - 'a'] = new Trie();
            }
            root = root.links[word.charAt(i) - 'a'];
        }
        root.wordEndingHere = true;
    }
    public boolean search(String word) {
        return matchPattern(word.toCharArray(), 0, trie_root);   
    }
    private boolean matchPattern(char[] word, int idx, Trie root) {
        if(idx == word.length) return root.wordEndingHere;
        if(word[idx] != '.') 
            return root.links[word[idx] - 'a'] != null && matchPattern(word, idx + 1, root.links[word[idx] - 'a']);
        else {
            for(int i = 0; i < root.links.length; i++) {
                if(root.links[i] != null && matchPattern(word, idx + 1, root.links[i])) return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */