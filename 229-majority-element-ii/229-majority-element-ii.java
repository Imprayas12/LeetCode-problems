class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            int count = map.getOrDefault(i,0);
            map.put(i,count+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()>nums.length/3) ans.add(entry.getKey());
        }
        return ans;
    }
}