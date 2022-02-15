class Solution {
    public int singleNumber(int[] arr) {
        Map<Integer,Integer> mp = new HashMap<>();
        for (int j : arr) {
            if (mp.containsKey(j))
                mp.replace(j, mp.get(j) + 1);
            else mp.put(j, 1);
        }
        for(var i : arr){
            if(mp.get(i)==1)
                return i;
        }
        return 0;
    }
}