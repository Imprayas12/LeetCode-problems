class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()) return false;
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(int i = 0; i < ransomNote.length(); i++){
            map1.put(ransomNote.charAt(i),map1.getOrDefault(ransomNote.charAt(i),0) + 1);
        }
        for(int i = 0; i < magazine.length(); i++){ map2.put(magazine.charAt(i),map2.getOrDefault(magazine.charAt(i),0) + 1);
        }
        for(Map.Entry<Character,Integer> map: map1.entrySet()) {
            char c = map.getKey();
            int f = map.getValue();
            if(map2.containsKey(c)) {
                if(map2.get(c) < f) return false; 
            }
            else
                return false;
        }
        return true;
    }
}