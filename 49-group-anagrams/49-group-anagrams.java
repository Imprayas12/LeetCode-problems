import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        for(var str : strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String tem = String.valueOf(temp);
            if(!mp.containsKey(tem)){
                mp.put(tem,new ArrayList<String>());
            }
            mp.get(tem).add(str);
        }
        return new ArrayList(mp.values());

    }
}