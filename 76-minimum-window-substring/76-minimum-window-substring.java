class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> mapS = new HashMap<>();
        Map<Character,Integer> mapT = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i),mapT.getOrDefault(t.charAt(i),0) + 1);
        }
        int reqLen = mapT.size();
        int low = 0;
        int high = 0;
        int len = 0;
        int t_low = 0;
        int t_hi = 0;
        int ans = -1;
        while(high < s.length()) {
            char curChar = s.charAt(high);
            int count = mapS.getOrDefault(curChar,0);
            mapS.put(curChar,count + 1);
            
            if(mapT.containsKey(curChar) && mapS.get(curChar).intValue() == mapT.get(curChar).intValue())
                len += 1;
            while(low <= high && len == reqLen) {
                var car = s.charAt(low);
                if(ans == -1 || high - low + 1 < ans) {
                    ans = high - low + 1;
                    t_low = low;
                    t_hi = high;
                    System.out.println(t_low + " " +t_hi);
                }
                mapS.put(car,mapS.get(car) - 1);
                if(mapT.containsKey(car) && mapS.get(car).intValue() < mapT.get(car).intValue())
                    len--;
                low++;
            }
            high++;
        }
        return ans == -1 ? "": s.substring(t_low,t_hi + 1);
    }
}