class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[pattern.length() + 1];
        int count = 1;
        for(int i = 0; i < pattern.length(); i++) {
            while(i < pattern.length() && pattern.charAt(i) == 'D') stack.push(i++);
            ans[i] = count++;
            while(!stack.isEmpty()) ans[stack.pop()] = count++;
        }
        if(ans[pattern.length()] == 0) ans[pattern.length()] = count;
        String s = "";
        for(int i: ans) s += i;
        return s;
    }
}