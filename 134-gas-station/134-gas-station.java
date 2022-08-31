class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        int currGas = 0;
        int remGas = 0;
        for(int i = 0; i < gas.length ; i++){
            currGas += gas[i]-cost[i]; 
            if(currGas < 0){
                index = i + 1;
                remGas += currGas;
                currGas = 0;
            }
        }
        return (remGas + currGas >= 0) ? index : -1;
    }
} 