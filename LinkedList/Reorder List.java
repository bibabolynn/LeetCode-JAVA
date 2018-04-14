Problem : Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

https://leetcode.com/problems/reorder-list/description/

Thought : revert the second half ,and merge the first half and second half


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
    public void reorderList(ListNode head) {
       if(head == null || head.next == null || head.next.next == null){
         return ;
       }
       /**
        * find the head of the second half
       **/
       ListNode slow = head,fast = head;
       while(fast != null && fast.next != null){
         slow = slow.next;
         fast = fast.next.next;
       }
       /**
        * revert second half
       **/
        ListNode tail = revertList(slow);
        /**
         * merge
        **/
        ListNode nextH = null,curH = head;
        ListNode nextT = null,curT = tail;
        //
        while( curH != curT && curH.next != curT){
             nextH = curH.next;
             nextT = curT.next;
             curH.next = curT;
             curT.next = nextH;

             curH = nextH;
             curT = nextT;
        }

    }
    public ListNode revertList(ListNode head){
    	if(head == null || head.next == null){
    	  return head;
    	}
    	
    	ListNode pre = head,cur = head.next,next = null;
    	while(cur != null){
    	    next = cur.next;
    	    cur.next = pre;
    	    pre = cur;
    	    cur = next;
    	}
    	head.next = null;
    	return pre;
    }
}
