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

Thought : 递归，2个2个的向上merge

Complexity Analysis :
Time Complexity O(mlogn),
Space complexity O(nlogn),n is the length of lists,m is the total length of all lists in lists

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
        
         ListNode[] first = new ListNode[lists.length/2];
         ListNode[]  second = new ListNode[lists.length - lists.length/2];
         for(int i = 0;i<lists.length;i++){
            if(i<lists.length/2){
               first[i] = lists[i];
            }else{
               second[i-lists.length/2] = lists[i];
            }
         	
         }
        
         return merge(mergeKLists(first),mergeKLists(second));
        
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
