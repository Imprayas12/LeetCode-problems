class Solution {
    public int hIndex(int[] citations) {
        int low = 0;
        int high = citations.length - 1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(citations.length - mid == citations[mid]) {
                return citations[mid];
            }
            else if(citations.length - mid > citations[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return citations.length - (high + 1);
    }
    private boolean isValid(int mid,int[] citations) {
        return citations.length - mid == citations[mid];
    }
}