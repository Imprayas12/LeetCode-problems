//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    public int wordLadderLength(String beginWord, String endWord, String[] wordList)
    {
        // Code here
        Set<String> words = new HashSet<>();
        for(var i: wordList) words.add(i);
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