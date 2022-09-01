/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
       int low = 1,right = n;
        while(low < right){
            int mid = low + (right - low)/2;
            if(isBadVersion(mid))
                right = mid;
            else low = mid + 1;
        }
        return low;
    }
}