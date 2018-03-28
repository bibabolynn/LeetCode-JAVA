Problem : Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
Example : 
	Input: 1->2->4, 1->3->4
	Output: 1->1->2->3->4->4
Thought : similar to mergeSort, only you don't need to sort
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode curr1= l1;
        ListNode next1 = null;
        ListNode curr2 = l2;
        ListNode next2 = null;
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        while (curr1 != null && curr2 != null){ 
            if(curr1.val <= curr2.val){
                next1 = curr1.next;
                curr.next = curr1;
                curr1.next = null;
                curr1 = next1;
            }else {
                next2 = curr2.next;
                curr.next = curr2;
                curr2.next=null;
                curr2 =next2; 
            }
            curr = curr.next;
            
        }
        while(curr1 != null){
           next1 = curr1.next;
                curr.next = curr1;
                curr1.next = null;
                curr1 = next1; 
             curr = curr.next;
        }
        while(curr2 != null){
             next2 = curr2.next;
                curr.next = curr2;
                curr2.next=null;
                curr2 =next2;
            curr = curr.next;
        }
        return newHead.next;
    }
    
}


recursive solution 
Complexity Analysis :Time Complexity O(n), Space complexity O(n)
public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
}
