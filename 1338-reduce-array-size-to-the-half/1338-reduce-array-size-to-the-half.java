class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }
        int[] ar = new int[map.size()];
        int i = 0;
        for(Map.Entry<Integer,Integer> m: map.entrySet()) {
            ar[i++] = m.getValue();
        }
        Arrays.sort(ar);
        int sum = 0;
        int len = 0;
        for(i = ar.length - 1; i>=0; i--){
                sum += 1;
                len += ar[i];
            if(len >= arr.length/2) return sum; 
        }
        return sum;
    }
}