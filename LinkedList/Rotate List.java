Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right -> 5->1->2->3->4->NULL
rotate 2 steps to the right -> 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right -> 2->0->1->NULL
rotate 2 steps to the right -> 1->2->0->NULL
rotate 3 steps to the right -> 0->1->2->NULL
rotate 4 steps to the right -> 2->0->1->NULL

https://leetcode.com/problems/rotate-list/description/

Thought :  if k is larger than  the length of the list , k = k%length ,
two extra nodes are needed,,one needs to be k%length steps ahead the other, then ,while the first one reaches the end of the list(the last node) the second one is at the node before newHead. point the first one to head. and point the second one to null



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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null  || k == 0){
            return head;
        }
        ListNode l1 = head, l2 = head;
        int len = 0;
        while(l1 != null){
            l1 = l1.next;
            len++;
        }
        if(k > len) {
            k = k%len;
        }
        if(k == len){
            return head;
        }
        l1 = head;
        while(k > 0  ){
           
            l1 = l1.next;
            k--;
        }
      
        while( l1.next != null){
              l1 = l1.next;
              l2 = l2.next; 
        }
        l1.next = head;
        ListNode newHead = l2.next;
        l2.next = null;
        return newHead;
    }
}
