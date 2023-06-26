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
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp = head;
        
        int idx = 0;
        while(temp != null){
            temp = temp.next;
            idx++;
        }
        
        if(idx == 1){
            return null;
        }else if(idx == 2){
            head.next = null;
            return head;
        }
        
        int mid = Math.round(idx/2);
        
        temp = head;
        idx = 0;
        while(idx < mid){
            idx++;
            temp = temp.next;
        }
        
        temp.val = temp.next.val;
        temp.next = temp.next.next;
        
        return head;
    }
}