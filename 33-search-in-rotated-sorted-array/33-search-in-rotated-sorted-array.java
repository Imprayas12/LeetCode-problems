import java.util.*;

class Solution {
    public int search(int[] nums, int target) {
        HashMap<Integer,Integer> hp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hp.put(nums[i],i);
        }
        ArrayList<Integer> AR = new ArrayList<>();
        for(int i=0;i<nums.length;i++) AR.add(nums[i]);
        Collections.sort(AR);
        for (int i = 0; i < nums.length; i++) nums[i] = AR.get(i);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (nums[m] == target)
                return hp.get(nums[m]);
            if (nums[m] < target)
                left = m + 1;
            else
                right = m - 1;
        }
        return -1;
    }
}