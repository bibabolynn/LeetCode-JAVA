Problem : Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.

https://leetcode.com/problems/reverse-nodes-in-k-group/description/

Thought : need a method to revert sublist ,need to link the head of the sublist to the tail of list that already been reverted ,link the tail of sublist to the head of node that haven't been delt with


Complexity Analysis :
Time Complexity O(n),
Space complexity O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
       if(head == null || head.next == null || k == 1){
         return head;
       }
       int count;
       ListNode fakeHead = new ListNode(0);
       fakeHead.next = head;
       ListNode tail = fakeHead;//tail is the end of list that already been reverted
       ListNode h = head,t = null;// h and t are the head and tail of the sublist needed to be reverted
       ListNode nextHead = h;//head of next sublist 
       while( h != null){
       	  count = k;
          while(count > 0 && nextHead != null){
          	t = nextHead;
       		nextHead = nextHead.next;
            count--;
	       }
	       if(count > 0){ // number of left-out nodes in the end is less than k,don't need revert
	         return fakeHead.next;
	       }
	       
	       tail.next = revert(h,nextHead);//revert return the head of sublist after revert
           tail = h;
	       h.next = nextHead;
	       h = nextHead;
       }
        return fakeHead.next;
    }
    public ListNode revert(ListNode head,ListNode tail){
    	if(head == tail || head.next == tail){
    	  return head;
    	}
    	ListNode pre = head,cur = head.next,next = null;
    	while(cur != tail){
    	  next = cur.next;
    	  cur.next = pre;
    	  pre = cur;
    	  cur = next;
    	}
    	return pre;
    }
}
