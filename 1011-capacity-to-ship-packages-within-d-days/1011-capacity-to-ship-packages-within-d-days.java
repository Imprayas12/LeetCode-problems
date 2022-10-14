class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCapacity = 0;
        int maxCapacity = 0;
        for(var i: weights) {
            minCapacity = Math.max(minCapacity,i);
            maxCapacity += i;
        }
        int ans = 0;
        while(minCapacity <= maxCapacity) {
            int currCapacity = minCapacity + (maxCapacity - minCapacity)/2;
            if(isEnough(currCapacity,weights,days)) {
                ans = currCapacity;
                maxCapacity = currCapacity - 1;
            }
            else minCapacity = currCapacity + 1;
        }
        return ans;
    }
    private boolean isEnough(int weight,int[] weights,int daysAvailable) {
        int daysRequired = 1;
        int i = 0;
        int currCap = 0;
        while(i < weights.length) {
            if(weights[i] + currCap <= weight) {
                currCap += weights[i];
                i++;
            }
            else {
                currCap = 0;
                daysRequired += 1;
            }
            if(daysRequired > daysAvailable) return false;
        }
        return true;
    }
}