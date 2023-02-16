/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) pq.add(lists[i]);
        }
        ListNode newList = new ListNode();
        ListNode temp = newList;
        while(!pq.isEmpty()) {
            ListNode top = pq.poll();
            temp.next = top;
            temp = temp.next;
            if(top.next != null) {
                pq.add(top.next);
            }   
        }
        return newList.next;
    }
}