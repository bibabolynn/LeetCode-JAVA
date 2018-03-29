Problem : Given a sorted linked list, delete all duplicates such that each element appear only once.
Example : 
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3.
Thought : 
Complexity Analysis :Time Complexity O(n), Space complexity O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode curr  = head;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            while(next != null && next.val == curr.val){
                curr.next = next.next;
                next =curr.next;
            }
            curr = next;
        }
        return head;
    }
    
    It's the same idea but the code is more clear.
    
    public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
        if (current.next.val == current.val) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    return head;
}
}
