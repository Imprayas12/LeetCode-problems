import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            int count = map.getOrDefault(nums[i],0);
            max = Math.max(count+1,max);
            map.put(nums[i],count+1);
        }
        for(Map.Entry<Integer,Integer> it: map.entrySet())
            if(it.getValue()==max) return it.getKey();
        return -1;
    }
    
}