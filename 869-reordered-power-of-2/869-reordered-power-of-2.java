class Solution {
    public boolean reorderedPowerOf2(int n) {
        // Map<Long,Long> map = new HashMap<>();
        int[] arr = countDigits(n);
        for(int i = 0; i < 31; ++i){
            if(Arrays.equals(countDigits(1 << i),arr)) return true;
        }
        return false;
    }
    
    private int[] countDigits(int n) {
        int[] arr = new int[10];
        while(n != 0) {
            arr[n % 10]++;
            n /= 10;
        }
        return arr;
    }
}