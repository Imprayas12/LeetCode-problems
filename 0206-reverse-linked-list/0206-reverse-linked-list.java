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
    public ListNode reverseList(ListNode head) {
        ListNode previous = null; //In front of list
        ListNode current = head; //Start of list
        while(current != null) { //Traverse till the end
            ListNode nextNode = current.next; //Temporarily store the next;
            current.next = previous; //Changing the links
            previous = current; // Move previous forward
            current = nextNode; // Move next forward
        }
        return previous; //New head
    }
}