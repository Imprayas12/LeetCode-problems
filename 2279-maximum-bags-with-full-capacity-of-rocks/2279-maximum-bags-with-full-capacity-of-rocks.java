class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        Integer[] diff = new Integer[capacity.length];
        for(int i = 0; i < capacity.length; i++) {
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        int ans = 0;
        // for(int i = 0; i < diff.length; i++) {
        //     System.out.println(additionalRocks + " " + diff[i]);
        //     if(additionalRocks - diff[i] >= 0) {
        //         diff[i] = 0;
        //         additionalRocks = additionalRocks - diff[i];
        //     }
        //     if(diff[i] == 0) ans += 1;
        // }
        int k = 0;
        while(additionalRocks > 0 && k < diff.length) {
            if(additionalRocks - diff[k] >= 0)
            {
                additionalRocks -= diff[k];
                diff[k] = 0;
            }  
            k++;
        }
        // System.out.println(Arrays.asList(diff));
        for(int i: diff) {
            if(i == 0) ans++;
        }

        return ans;
    }
}