Problem : Sort a linked list in O(n log n) time using constant space complexity.

https://leetcode.com/problems/sort-list/description/

Thought : merge sort


Complexity Analysis :
Time Complexity O(nlogn),
 Space complexity O(1),  althought it needs constant number of extra node ,recursion stack causes logn space

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head; 
    // step 1. cut the list to two halves
    ListNode prev = null; //node before slow 
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
 
    prev.next = null;// point the end node of the first half to null
    
    // step 2. sort each half
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);
    
    // step 3. merge l1 and l2
    return merge(l1, l2);
  }
  
  ListNode merge(ListNode l1, ListNode l2) {
    ListNode fakeHead = new ListNode(0), curr = fakeHead;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }
    
    if (l1 != null){
      curr.next = l1;
    }
    
    if (l2 != null){
    	curr.next = l2;
    }
 
    return fakeHead.next;
  }

}
