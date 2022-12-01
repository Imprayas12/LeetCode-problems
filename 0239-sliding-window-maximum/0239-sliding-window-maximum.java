class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int idx = 1;
        int[] ans = new int[arr.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[i] > arr[deque.getLast()]) {
                deque.removeLast();
            }
            deque.add(i);
        }
        ans[0] = arr[deque.getFirst()];
        for (int i = k; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[i] > arr[deque.getLast()]) deque.removeLast();
            deque.add(i);
            if(!deque.isEmpty() && deque.getFirst() == i - k){
                deque.removeFirst();
            }
            ans[idx++] = arr[deque.getFirst()];
        }
        return ans;
    }
}