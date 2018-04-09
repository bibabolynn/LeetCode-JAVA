Problem : Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

Thought :  to find the nth node from the end of list, you need two nodes, one is n steps ahead the other, so when one reaches the end of the list( is null), the other one will be (n-1)th node from the end of list , point (n-1)th node to (n+1)th node or null if there isn't a (n+1)th node

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
     public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = head;//
        ListNode step = head;
        while(n > 0 && step != null){
        	step = step.next;
            n--;
        }
        if(step == null){  //n is the length of the list, the node to be removed is the head
          return head.next;
        }
        while(step.next != null){
          step = step.next;
          prev = prev.next;
        }
        //now ,prev is the node before the node needs to be removed
        // because n is valid ,so prev.next can not be null
        prev.next = prev.next.next;
        return head;
    }
}
