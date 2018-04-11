Problem : Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?

https://leetcode.com/problems/linked-list-cycle-ii/description/

Thought : 
two nodes ,fast and slow, fast runs two steps at a time, slow runs one step at a time,if there is no cycle, fast will reach the end of the list ,if there is a cycle, there is a point where fast == slow 
head l1  node where cycle begins
|---------|-------------l2     
          |            |
          |            |
          |            - node where fast and slow meet
      l3  |            |
          |            |
          --------------
l1 is the distance from head to node where cycle begins;
l2 is the distance from node where cycle begins to node where fast and slow meet;
l3 is the distance from node where fast and slow meet to node where cycle begins;

distance slow goes is l1+l2;
distance fast goes is l1+l2+l3+l2;
l1+l2+l3+l2 = 2(l1+l2)  ----->   l1= l3
so after fast meets slow ,if slow goes from head and fast goes from node where fast and slow meet, and they both go one step at a time then they will meet again at node where cycle begins

Complexity Analysis :
Time Complexity O(3n+3m),n is the number of node in l1,m is number of nodes in l2.
 Space complexity O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
           fast = fast.next.next;
           slow = slow.next;
           if(fast == slow){
             break;
           }
        }
        if(fast == null || fast.next == null){//no cycyle
          return null;
        }
        slow = head;
        while(slow != fast){// slow and fast will meet again at node where cycle beings
           slow = slow.next;
           fast = fast.next;
        }
        return fast;
    }
}
