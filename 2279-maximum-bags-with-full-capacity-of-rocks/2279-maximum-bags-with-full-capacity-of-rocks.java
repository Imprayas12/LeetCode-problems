class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        Integer[] difference = new Integer[capacity.length];
        for(int i = 0; i < capacity.length; i++) {
            difference[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(difference);
        int ans = 0;
        int k = 0;
        while(additionalRocks > 0 && k < difference.length) {
            if(additionalRocks == 0) break;
            if(additionalRocks - difference[k] >= 0){
                additionalRocks -= difference[k];
                difference[k] = 0;
            }  
            k++;
        }
        for(int i: difference) {
            if(i == 0) ans++;
        }

        return ans;
    }
}