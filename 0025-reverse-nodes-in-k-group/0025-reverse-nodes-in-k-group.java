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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        while(temp != null && count < k) {
            count++;
            temp = temp.next;
        }
        if(count == k) {
            temp = reverseKGroup(temp,k);
            while(count-->0) {
                ListNode tmp = head.next;
                head.next = temp;
                temp = head;
                head = tmp;
            }
            head = temp;
        }
       return head; 
    }
}