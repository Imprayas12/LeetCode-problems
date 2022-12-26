class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        int ans = 1;
        while(!queue.isEmpty()) {
            for(int i = queue.size(); i > 0; i--) {
                String curWord = queue.poll();
                if(curWord.equals(endWord)) return ans;
                for(int j = 0; j < curWord.length(); j++) {
                    for(char k = 'a'; k <= 'z'; k++) {
                    char[] curWordArr = curWord.toCharArray();
                        curWordArr[j] = k;
                        String temp = new String(curWordArr);
                        if(words.contains(temp) && !visited.contains(temp)){
                            visited.add(temp);
                            queue.add(temp);
                        }
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}