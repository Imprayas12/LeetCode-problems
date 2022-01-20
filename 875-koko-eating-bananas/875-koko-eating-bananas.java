import java.util.*;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high =1 ;
        for(int i=0;i<piles.length;i++){
            high = Math.max(high,piles[i]);
        }
        while(low<high){
            int m = (low+high)/2;
            int k=0;
            for(var i : piles){
                k+=Math.ceil((double)i/m);
            }
            if(k<=h) high = m;
            else low = m+1;
        }
        return high;
    }
}