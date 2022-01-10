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
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode head = new ListNode();
        ListNode dum = head;
        while(p1!=null && p2 !=null){
            if(p1.val< p2.val) {
                dum.next = p1;
                p1 = p1.next;
            }
            else {
                dum.next = p2;
                p2 = p2.next;
            }
            dum=dum.next;
        }
        if(p1!=null){
            dum.next = p1;
        }
        if(p2!=null){
            dum.next = p2;
        }
        return head.next;
    }
}