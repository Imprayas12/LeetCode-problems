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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0;
        int car=0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int dig=0;
        ListNode h1 = new ListNode();
        ListNode ptr = h1;
        while(l1!=null || l2 !=null){
            sum=0;
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            dig = x+y;
            sum+=(dig+car);
            ptr.next = new ListNode(sum%10);
            ptr= ptr.next;
            car=sum/10;
            if(l1!=null )l1=l1.next;
            if(l2!=null)l2=l2.next;
        }
        if(car>0){
            ptr.next = new ListNode(car);
        }       
        return h1.next;
    }
}