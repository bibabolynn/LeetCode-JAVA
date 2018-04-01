Problem : Given a singly linked list, determine if it is a palindrome.
Thought : revert the first half of the list and compare values of the nodes to the second half.
to find the head of the second half of the list. Two pointers are needed as one is two times faster than the other. When the fast reaches the end of the list. you will have:
1 --> 2 --> 3 --> 4 -->5 --> null when odd numbers of nodes are in the list
            slow       fast
1 --> 2 --> 3 --> 4 -->5 --> 6 --> null when even numbers of nodes are in the list
                 slow              fast
As the slow  pointer goes down the list ,revert nodes it passes by

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
    public boolean isPalindrome(ListNode head) {
        if(head == null )
            return true;
        ListNode fast = head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while( fast != null && fast.next != null ){     
            //fast pointer must goes first,before the revert happens ,otherwise will occure null pointer exception 
            fast = fast.next.next;
            //revert while the slow pointer goes one step
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;           
        }
        /** now the list will be 
         * null <-- 1 <-- 2        3 --> 4 --> 5 --> null 
         *               prev  curr(slow)   fast

         *   null <-- 1 <-- 2 <-- 3     4 --> 5 --> 6 --> null    
         *                        prev curr               fast          
        if(fast != null){// when the list has odd nodes
           curr = curr.next
        }
        //compare two lists;
       while(curr != null){
           if(curr.val != prev.val){
               return false;
           }
           curr = curr.next;
           prev = prev.next;
       }
        return true;
    }
    
}


if you want the original list unchanged ,
you will have to  revert the first half back and point the end node of the first half list to the head of the second half of the list
