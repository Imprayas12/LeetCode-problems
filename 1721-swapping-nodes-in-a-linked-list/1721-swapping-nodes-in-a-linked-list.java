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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode kthFromStart = head;
        int i = 1;
        ListNode right = head;
        while(i < k) {
            kthFromStart = kthFromStart.next;
            right = right.next;
            i++;
        }
        
        ListNode kthFromRight = head;
        while(right.next != null) {
            right = right.next;
            kthFromRight = kthFromRight.next;
        }
        int temp = kthFromRight.val;
        kthFromRight.val = kthFromStart.val;
        kthFromStart.val = temp;
        return head;
    }
}