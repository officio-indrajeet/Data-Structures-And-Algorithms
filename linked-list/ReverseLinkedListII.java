// 92. Reverse Linked List II (Medium)
// https://leetcode.com/problems/reverse-linked-list-ii/

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head == null || head.next == null)
            return head;
        
        int pos = 1;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode nodeBeforeSublist = dummy;
        
        while(pos < left) {
            nodeBeforeSublist = nodeBeforeSublist.next;
            pos++;
        }
        
        ListNode workingPtr = nodeBeforeSublist.next;
        
        while(left < right) {
            
            ListNode nodeToBeExtracted = workingPtr.next;
            workingPtr.next = nodeToBeExtracted.next;
            nodeToBeExtracted.next = nodeBeforeSublist.next;
            nodeBeforeSublist.next = nodeToBeExtracted;
            
            left++;
        }
        
        return (dummy.next);
        
    }
}
