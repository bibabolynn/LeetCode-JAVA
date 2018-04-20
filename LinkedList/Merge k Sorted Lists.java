Problem : Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

https://leetcode.com/problems/merge-k-sorted-lists/description/

Thought : 递归，2个2个的向上merge， 把lists[0]和lists[1] merge到list[0]上，list[2]和list[3] merge到 list[2]上，...,依次类推，然后第二遍循环 merge list[0] 和 list[2] 到 list[0]上，.... 依次循环

Complexity Analysis :
ime complexity : O(Nlogk) where k is the number of linked lists.N is the total number of result list

We can merge two sorted linked list in O(n) time where n is the total number of nodes in two lists.
Sum up the merge process and we can get:O(Nlogk)
Space complexity : O(1)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
         if(lists.length == 0){
           return null;
         }
         if( lists.length == 1){
           return lists[0];
         }
        int interval = 1;
        while(interval < lists.length){
          for(int i = 0; i< lists.length - interval; i +=interval*2){
            lists[i] = merge(lists[i],lists[i+interval]);
          }
          interval *= 2;
        }
        return lists[0];
        
    }
    public ListNode merge(ListNode l1,ListNode l2){
         if(l1 == null ){
            return l2;
         }
         if(l2 == null){
           return l1;
         }
         ListNode fakeHead = new ListNode(0);
         ListNode curr = fakeHead;
         while(l1 != null && l2 != null){
         	 if(l1.val <= l2.val){
	           curr.next = l1; 
	           l1 = l1.next;
	         }else{
	            curr.next = l2;
	            l2 = l2.next;
	         }
	         curr = curr.next;
         }
         if(l1 != null){
           curr.next = l1;
         }
         if(l2 != null){
            curr.next = l2;
         }
         return fakeHead.next;
    }
}
