Problem : You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example :
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

Thought :  
     if there is a carry ,it should be added to the sum of the values of the next node's          
     special case: short list reaches the end ,and what's left of the long list all value 9 and carry is 1    
Complexity Analysis :Time Complexity O(n), Space complexity O(n+1) ,n is the length of the long list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
/**
 * my solution ,to many shit steps ,code is not clear at all ,watch the solution after it ,the 
 * idea is the same but code is much clear
**/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int val = 0;
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        while(l1 != null && l2 != null){
           val = l1.val + l2.val + carry;
           if(val >= 10){
               carry = 1;
               val = val % 10;
           }else{
              carry = 0;
           }
           curr.next = new ListNode(val);
           curr = curr.next;
           l1 = l1.next;
           l2 = l2.next;

        }
        while(l2 != null && carry == 1){
          val = l2.val + carry;
               if(val >= 10){
                   carry = 1;
                   val = val % 10;
               }else{
                  carry = 0;
               }
                curr.next = new ListNode(val);
            	curr = curr.next;
            	l2 = l2.next;
           
        }
        if(l2 != null && carry == 0){
             curr.next = l2;
        }
        while(l1 != null && carry == 1){
          val = l1.val + carry;
               if(val >= 10){
                   carry = 1;
                   val = val % 10;
               }else{
                  carry = 0;
               }
                curr.next = new ListNode(val);
            	curr = curr.next;
            	l1 = l1.next;
           
        }
        if(l1 != null && carry == 0){
             curr.next = l1;
        }
        if( l1 == null && l2 == null){
			if(carry == 1){
            	curr.next = new ListNode(carry);
            }
        }
        return newHead.next;
    }



}


public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}

