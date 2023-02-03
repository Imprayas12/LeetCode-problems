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
    ListNode left;
    ListNode right;
    int size = 0;
    public boolean isPalindrome(ListNode head) {
        left = head;
        while(left != null) {
            left = left.next;
            size++;
        }
        left = head;
        return reverseAux(left,0);
    }
	private boolean reverseAux(ListNode head,int level) {
		if(head == null) return true;
		if(reverseAux(head.next,++level) == false) return false;
		if(level > size / 2) {
            if(left.val != head.val) return false;
		}
        left = left.next;
        return true;
	}
}