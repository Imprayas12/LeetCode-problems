class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                nums3[k]=nums1[i];
                i++;
            }
            else
            {
                nums3[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i<nums1.length){
            nums3[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            nums3[k]=nums2[j];
            j++;
            k++;
        }
        int m = nums3.length;
        double med;
        if(m%2==0)
            med = ((double) nums3[(m/2) - 1] +(double) nums3[((m+2)/2) -1])/2;
        else
            med = (double) nums3[(m+1)/2 - 1];
        return med;
    }
}