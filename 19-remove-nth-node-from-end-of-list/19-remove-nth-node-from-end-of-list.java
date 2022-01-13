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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = head;
        int len=1;
        while(ptr.next!=null){
            ptr=ptr.next;
            len++;
        }
        int f=len-n;
        int c=1;
        if(f==0) return head.next;
        ptr=head;
        while(c!=f){
            ptr=ptr.next;
            c++;
        }
        ptr.next = ptr.next.next;
        return head;
    }
}