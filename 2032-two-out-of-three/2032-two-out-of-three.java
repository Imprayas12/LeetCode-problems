class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3){
        Set<Integer> s1 = new HashSet<>();
        for(int i: nums1) s1.add(i);
        Set<Integer> s2 = new HashSet<>();
        for(int j: nums2) s2.add(j);
        Set<Integer> s3 = new HashSet<>();   
        for(int i: nums3) s3.add(i);
        Set<Integer> ansSet = new HashSet<>();
        for(int i: s1) {
            if(s2.contains(i) || s3.contains(i)) ansSet.add(i);
        }
        for(int i: s2) {
            if(s1.contains(i) || s3.contains(i)) ansSet.add(i);
        }
        for(int i: s3) {
            if(s1.contains(i) || s2.contains(i)) ansSet.add(i);
        }
        return new ArrayList<>(ansSet);
    }
}