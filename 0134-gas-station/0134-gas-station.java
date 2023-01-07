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

/*
Start from the first index and check if the amount of gas available at current station is enough to travel to next station or not. If the amount of gas available is not enough then it means that we cannot start from the index with which we started. hence we will change the index and then we'll set the current gas amount to zero and before setting it to zero we will add the difference in totalGas variable which will help us to decide if we can travel the whole array or not. If the totalGas amount is negative then it means that we cannot travel the whole array with the given sequence of gas stations and cost.

*/