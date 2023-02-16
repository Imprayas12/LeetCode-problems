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
        for(ListNode lst: lists) {
            while(lst != null) {
                pq.add(lst);
                lst = lst.next;
            }
        }
        ListNode newNode = new ListNode(0);
        ListNode temp = newNode;
        while(!pq.isEmpty()) {
            ListNode n = new ListNode(pq.poll().val);
            temp.next = n;
            temp = temp.next;
        }
        return newNode.next;
    }
}