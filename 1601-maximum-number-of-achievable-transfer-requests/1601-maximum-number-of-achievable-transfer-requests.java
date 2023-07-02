class Solution {
    int answer = 0;
    public int maximumRequests(int n, int[][] requests) {
        int[] inDegree = new int[n];
        helper(0,0,inDegree,requests);
        return answer;
    }
    private void helper(int index,int count, int[] indegree,int[][] requests) {
        if(index == requests.length) {
            
            for(int i: indegree) {
                if(i != 0) return;    
            }
            answer = Math.max(answer, count);
            return;
        }
        
        
        indegree[requests[index][0]]--;
        indegree[requests[index][1]]++;
        helper(index + 1, count + 1, indegree,requests);
        indegree[requests[index][0]]++;
        indegree[requests[index][1]]--;
        helper(index + 1, count, indegree, requests);
    }
}