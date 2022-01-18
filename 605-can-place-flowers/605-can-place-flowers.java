class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size  = flowerbed.length;
        int c=0;
        for(int i=0;i<size && c<n;i++){
            if(flowerbed[i]==0){
                int next = (i==size-1) ? 0 : flowerbed[i+1];
                int prev = (i==0) ? 0 : flowerbed[i-1];
                if(next == 0 && prev == 0){
                    flowerbed[i]=1;
                    c++;
                }
            }
        }
        return c==n;
    }
}