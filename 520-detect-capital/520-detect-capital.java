class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()==1) return true;
        else if(word.charAt(0)>='A'&& word.charAt(0)<='Z'){
            int c=0;
            for(int i=1;i<word.length();i++){
                if(word.charAt(i)>='a' && word.charAt(i)<='z') c++;
            }
            if(c==word.length()-1|| c==0) return true;
            return false;
        }
        else{
            for(int i=1;i<word.length();i++){
                if(word.charAt(i)>='A' && word.charAt(i)<='Z') return false;
            }
        }
        return true;
    }
}