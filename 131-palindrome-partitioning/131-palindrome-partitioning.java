class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList();
        part(0,s,ans,path);
        return ans;
    }
    private void part(int index,String s,List<List<String>> ans,List<String> path){
        if(index==s.length()){
            ans.add(new ArrayList(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPal(s,index,i)){
                path.add(s.substring(index,i+1));
                part(i+1,s,ans,path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPal(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
}