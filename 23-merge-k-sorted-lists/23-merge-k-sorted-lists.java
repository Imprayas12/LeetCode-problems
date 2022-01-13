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
     ArrayList<Integer> AR = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
         ListNode hf = lists[i];
            while(hf!=null){
                AR.add(hf.val);
                hf=hf.next;
            }
        }
        Collections.sort(AR);
        ListNode head = new ListNode(0);
        ListNode dum = head;
        for(int i=0;i<AR.size();i++){
            ListNode temp = new ListNode(AR.get(i));
            dum.next = temp;
            dum = dum.next;
        }
        dum.next = null;
        return head.next;
    }
}