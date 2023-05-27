class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int current_gas = 0;
        int remaining_gas = 0;
        int n = gas.length;
        for(int i = 0; i < n; i++) {
            current_gas += gas[i] - cost[i];
            if(current_gas < 0) {
                start = i + 1;
                remaining_gas += current_gas;
                current_gas = 0;
            }
        }
        return remaining_gas + current_gas >= 0 ? start : -1;
    }
}