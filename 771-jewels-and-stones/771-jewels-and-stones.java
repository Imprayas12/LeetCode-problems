class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character,Integer> map = new HashMap<>();
        char[] arr = jewels.toCharArray();
        for(int i = 0; i< arr.length;i++)
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        int ans = 0;
        for(int i = 0; i < stones.length(); i++) {
            ans += map.getOrDefault(stones.charAt(i),0);
        }
        return ans;
    }
}