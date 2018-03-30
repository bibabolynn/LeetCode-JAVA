Problem : Given a linked list, determine if it has a cycle in it.
Thought : two pointers ,both start from head, slow pointer goes one step at a time while the fast one goes two steps at a time.
   If it has a cycle,ListNode slow and fast have to meet at some point.
Complexity Analysis :Time Complexity O(n), Space complexity O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null ){
            return false;
        }
        ListNode slow = head, fast = head;
        while(fast != null && fast.next !=null){
            
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}

Follow up:
Can you solve it without using extra space?
