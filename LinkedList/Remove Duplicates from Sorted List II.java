Problem : Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

Thought : need a node before the head node, in case situation like  1->1->1->2->3, return 2->3.
need a node curr and a node next to iterate the list and compare values.
when curr.val != next.val  if curr.next == next  means curr doesn't have a duplicate ,then pre = curr  if curr.next!= next means curr have duplicates, then pre .next = next to remove curr and it's duplicates


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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
          return head;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode prev = h,curr = head,next=head.next;
        
        while(next != null){
            if(curr.val == next.val){
               next = next.next;
            }else{
               if(curr.next == next){
                 prev = curr;
                 
               }else{
                 prev.next = next;
               }
               curr = next;
               next = next.next;
            }
           
        }
        if(curr.next != next){
          prev.next = next;
        }
        return h.next;
    }
}


change the problem to 
Given 1->2->3->3->4->4->5, return 1->2->3->4->5.
Given 1->1->1->2->3, return 1->2->3.
class Solution{
  public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
          return head;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode prev = h,next=head.next;
        int val= head.val;
        while(next != null){
            
           if(val != next.val){
              
               prev = next;
               val = next.val;  
           }else{
               prev.next = next.next;
           }
            next = next.next;
        }
        return h.next;
    }
}    
