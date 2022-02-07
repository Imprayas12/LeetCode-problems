class Solution {
    public char findTheDifference(String s, String t) {
        int i=0,j=0;
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        Arrays.sort(S);
        Arrays.sort(T);
        while(i<s.length() && j<t.length()){
            if(S[i]!=T[j])
                return T[j];
            i++;
            j++;
        }
        return T[t.length()-1];
    }
}