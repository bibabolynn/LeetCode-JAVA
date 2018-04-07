Problem : Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

Thought :  
k1 -> k2 -> k3 -> k4
 the first pair k1 -> k2  to revert ,k1.next.next = k1; 
 if there is still a pair after current pair,to link this pair with next , k1.next = k1.next.next.next
 if there are only one node after current pair, k1.next = k1.next.next
 if none node after current pair, k1.next = null;
     
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
    public ListNode swapPairs(ListNode head) {
           if(head == null || head.next == null){
          return head;
        }
        ListNode curr = head;
        ListNode newHead = head.next;
        ListNode nextnext = null;
        while(curr != null && curr.next != null ){
        	nextnext = curr.next.next;
        	curr.next.next = curr;
        	if(nextnext == null){
        		curr.next = null;
        	}else if(nextnext.next == null){
        	  curr.next = nextnext;
        	}else{
        		curr.next = nextnext.next;
        	}
        	
        	curr = nextnext;
        }
        return newHead;
    }
}
