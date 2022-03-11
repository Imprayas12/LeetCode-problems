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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        temp = head;
        int[] Temp = new int[size];
        for(int i=0;i<size;i++){
            Temp[i]= temp.val;
            temp = temp.next;
        }
        k=k%size;
        for(int i=0;i<k;i++){
            int last=Temp[size-1];
            for(int j=size-1;j>0;j--){
                Temp[j]=Temp[j-1]; 
            }
            Temp[0]=last;
        }
        ListNode ans = new ListNode(Temp[0]);
        temp = ans;
        for(int i=1;i<size;i++){
         temp.next = new ListNode(Temp[i]);
            temp = temp.next;
        }
        return ans;
    }
}