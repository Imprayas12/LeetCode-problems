class Solution {
    public boolean halvesAreAlike(String s) {
        int c1=0,c2=0;
        char[] vow={'a','e','i','o','u','A','E','I','O','U'};
        Set<Character> st=new HashSet<>();
        for(char c:vow) st.add(c);
        for(int i=0;i<s.length();i++){
            if(st.contains(s.charAt(i))){
                if(i<s.length()/2) c1++;
                else c2++;
            }
        }
        System.out.println(c1+" "+c2);
        return c1==c2;
    }
}