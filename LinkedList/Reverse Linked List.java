Problem : Reverse a singly linked list.
Example : 
   Given: 1 --> 2 --> 6 
   Return: 6 --> 2 --> 1
Thought : need 3 extra ListNode (before,curr,next),ListNode next to remember where curr need to be after revert curr and  before(curr.next = before), don't forget head.next = null 
Attention : an extra ListNode is always helpful
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
    public ListNode reverseList(ListNode head) {
       if(head == null || head.next == null){
          return head;
       }
       ListNode before = new ListNode(0);
       before.next = head;
       ListNode curr = head;
        ListNode next = head.next;
       while(next != null){
         curr.next = before;
         before = curr;
         curr = next;
         next = next.next;
       }
       curr.next = before;
       head.next = null;
       return curr;
        
    }
}



Complexity Analysis :Time Complexity O(n), Space complexity O(1)
 (Iterative)
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
}
Thought :given a linkedlist ...Km-1 --> Km --> Km+1 ... Kn ..., 
to revert Km...Kn,you want to put Km+1 between Km-1 and Km  ,so the link would be 
 ...Km-1 --> Km+1 --> Km --> Km+2 ... Kn ...,
 and then you want to put  Km+2 between Km-1 and Km+1 ,so the link would be  
 ...Km-1 --> Km+2 --> Km+1 --> Km --> Km+3 ... Kn ...,  etc,
until you put Kn between Km-1 and Kn-1. so the link would be ...Km-1--> Kn--> Kn-1 ....Km -->Kn+1 ...
  public ListNode reverseList(ListNode head) {
       if(head == null || head.next == null){
          return head;
       }
       ListNode fakeHead = new ListNode(0);
       fakeHead.next = head;
        ListNode pre = fakeHead;
       ListNode curr = head;
        ListNode next = head.next;
       while(next != null){
         curr.next = next.next;
         next.next = pre.next;
           pre.next = next;
           next = curr.next;
       }
       
       return fakeHead.next;
        
    }

Thought : 
Assume from node nk+1 to nm had been reversed and you are at node nk.n1 → … → nk-1 → nk → nk+1 ← … ← nm,We want nk+1’s next node to point to nk.
So,nk.next.next = nk;Be very careful that n1's next must point to Ø
Time complexity : O(n)
Space complexity : O(n). The extra space comes from implicit stack space due to recursion. The recursion could go up to nn levels deep.
(Recursive)
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}
