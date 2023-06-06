class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length == 1) return true;
        int n = arr.length;
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for(int i = 0; i < n - 1; i++) if(arr[i + 1] - arr[i] != diff) return false;
        return true;
    }
}