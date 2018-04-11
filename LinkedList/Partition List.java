Problem : Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.


For example
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.


https://leetcode.com/problems/partition-list/description/

Thought :  separate original list into two list ,one has all nodes that less than x,the other one has all nodes that greater than x. And link these two lists 

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
     public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
          return head;
        }
        ListNode curr = head;// to iterator original list
        ListNode next = null;
       // greaterHead is the head of the greater nodes
        ListNode greaterHead = new ListNode(0), gCurr = greaterHead;
         //lessHead is the head of the less nodes
        ListNode lessHead = new ListNode(0), lCurr = lessHead;
        
        while( curr != null){
        	next = curr.next;
        	if(curr.val >= x){
        	  gCurr.next = curr;
        	  gCurr = gCurr.next;
        	}else{
        	  lCurr.next = curr;
        	  lCurr = lCurr.next;
        	}
        	curr.next = null;
        	curr = next;
        }
        lCurr.next = greaterHead.next;
        return lessHead.next;
    }
}
