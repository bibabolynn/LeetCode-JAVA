Problem : Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...

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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
          return head;
        }
        ListNode oddHead = head, evenHead = head.next;
        ListNode odd = oddHead, even = evenHead;
        ListNode curr = evenHead.next;
        int count = 1;
        while(curr != null){
        	if(count % 2 != 0){
        		odd.next = curr;
        		odd = odd.next;
        	}else{
        		even.next = curr;
        		even = even.next;
        	}
        	curr = curr.next;
        	count ++;
        }
        odd.next = evenHead;
        even.next = null;
        return oddHead;
    }
}


public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        /**
         * odd.next = even.next;
         * even.next = even.next.next;
         * the tailnode of the  evenlist must  points to null,the tailnode of the oddlist points 
         * to the head of the evenlist
         * if length of list is odd, cycle ends at even is null, the tailnode of evenlist point 
         * to tailnode.next.next which is null at step three
         * if length of list is even ,cycle ends at even.next is null, so the tailnode of 
         * evenlist points to null
         **/
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;//step three
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
