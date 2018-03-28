Problem : Reverse a linked list from position m to n. Do it in-place and in one-pass.Given m, n satisfy the following condition:1 ≤ m ≤ n ≤ length of list.
Example : 
   Given 1->2->3->4->5->NULL, m = 2 and n = 4,
   return 1->4->3->2->5->NULL.
Thought : given a linkedlist ...Km-1 --> Km --> Km+1 ... Kn ..., 
to revert Km...Kn,you want to put Km+1 between Km-1 and Km  ,so the link would be 
 ...Km-1 --> Km+1 --> Km --> Km+2 ... Kn ...,
 and then you want to put  Km+2 between Km-1 and Km+1 ,so the link would be  
 ...Km-1 --> Km+2 --> Km+1 --> Km --> Km+3 ... Kn ...,  etc, until you put Kn between Km-1 and Kn-1. so the link would be ...Km-1--> Kn--> Kn-1 ....Km -->Kn+1 ...

Complexity Analysis :Time Complexity O(n)(now n is not the length of the link ,but the given number n), Space complexity O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
     if(head == null) return null;
    ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
    dummy.next = head;
    ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing( to mark Km-1)
    for(int i = 0; i<m-1; i++) pre = pre.next;
    
    ListNode start = pre.next; //  
    ListNode then = start.next; //  
    
    // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
    // dummy-> 1 -> 2 -> 3 -> 4 -> 5
    
    for(int i=0; i<n-m; i++)
    {
        // to keep list linked after remove listnode "then" to the place between "pre" and "pre.next"
        start.next = then.next;

		// remove listnode "then" to the place between "pre" and "pre.next"
        then.next = pre.next;
        pre.next = then;
        // mark nextnode to remove to the place between "pre" and "pre.next"
        then = start.next;
    }
    
    // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
    
    return dummy.next;
}
