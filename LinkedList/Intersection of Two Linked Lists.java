Problem : Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

Thought : two lists may not have the same length, try and find the node in the longer list as it's new head so the two lists will have the same length. Then traverse through the lists, one node at a time, if  they have intersection , they are guaranteed to reach the intersection node at the same time ,return the first intersection node.

Complexity Analysis :Time Complexity O(2n+m), Space complexity O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lenA = 0, lenB = 0;
        ListNode a = headA,b = headB;
        while(a != null){
            a = a.next;
            lenA++;
        }
        while( b != null){
            b = b.next;
            lenB++;
        }
        int diff = 0;
        ListNode longHead= null;
        ListNode shortHead = null;
        if(lenB >= lenA){
            diff = lenB -lenA;
            longHead = headB;
            shortHead = headA;
        }else{
            diff = lenA - lenB;
            longHead = headA;
            shortHead = headB;
        }
        while(diff > 0){
            longHead = longHead.next;
            diff --;
        }
        while(longHead != null){
            if(longHead == shortHead){
                return longHead;
            }
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return null;
    }
}


Thought : Maintain two pointers pA and pB initialized at the head of A and B, respectively. Then let them both traverse through the lists, one node at a time.
When pA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.); similarly when pB reaches the end of a list, redirect it the head of A.
If at any point pA meets pB, then pA/pB is the intersection node.

Complexity Analysis :Time Complexity O(n+m), Space complexity O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
       
        ListNode a = headA,b = headB;
        /**
         * if they have same lengths, they will both be null at the same time
         * if they don't have same lengths, after a redirect to headB,b redirect headA, a and b * will both be null at the same time;
         * in the mean time ,if a meets b ,it's the intersection node;
         **/
        while(a != null || b != null){// 
            if( a == b){
                return a;
            }
            if(a ==null){
               a = headB;
            }else{
                a = a.next;
            }
           if(b == null){
             b = headA;
           }else{
               b = b.next;
           }
           
        }
       
        return null;
    }
}

