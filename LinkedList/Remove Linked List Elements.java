Problem : Remove all elements from a linked list of integers that have value val.
Example : 
   Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
   Return: 1 --> 2 --> 3 --> 4 --> 5
   Thought : if node.val == val  (the node before this node).next = (this node).next;  for the first node, you need a node before it, new one;
   Complexity Analysis :Time Complexity O(n), Space complexity O(n),The extra space comes from implicit stack space due to recursion. The recursion could go up to nn levels deep.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
   public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode curr = fakeHead;
        while(curr.next !=null){
          if(curr.next.val == val){
            curr.next = curr.next.next;
          }else {
             curr = curr.next;
          }
        }
        return fakeHead.next;
   }

   public ListNode removeElements2(ListNode head, int val){
   		if(head == null) return null;
   		head.next = removeElements2(head.next,val);
   		return head.val == val ?  head.next : head;
   }
}
