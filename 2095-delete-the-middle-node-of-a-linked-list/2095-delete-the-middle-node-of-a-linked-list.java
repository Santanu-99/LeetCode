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
        if(head.next == null){
            return null;
        }
        else if(head.next.next == null){
            head.next = null;
            return head;
        }
        ListNode slow , fast;
        slow = fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        deleteNode(slow);
        
        return head;
    }
    
    void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
}