Problem : You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

Thought :  (from discuss @youshan)
   Carry(进位) is at most 1. 
   add a new node as a head in case the sum of the values of two head's produces a carry
   lastnot9node is the last node in those whose value is not 9, so when a carry is produced it's value will add 1,and nodes after it(whose values must be 9) will be set to 0
   Explanation:
   after step one end:
    l1: 9 -> 7 -> 7 -> 9 -> 1
    	l1
    l2:      2 -> 2 -> 9 -> 9
    		 l2
    dummy:  0
            tail
            lastnot9node
    after step two end:
    l1: 9 -> 7 -> 7 -> 9 -> 1
    	     l1
    l2:      2 -> 2 -> 9 -> 9
    		 l2
    dummy:  0 -> 9
            tail
            lastnot9node
    before 9 + 9 starts in step three:
     l1: 9 -> 7 -> 7 -> 9 -> 1
    	                l1
    l2:       2 -> 2 -> 9 -> 9
    		            l2
    dummy:  0 -> 9 -> 9 -> 9
       lastnot9node      tail
                 
	before 9 + 9 starts in step three:
	 l1: 9 -> 7 -> 7 -> 9 -> 1
    	                     l1
    l2:       2 -> 2 -> 9 -> 9
    		                 l2
    dummy:  1 -> 0 -> 0 -> 0 -> 8
                               tail
                               lastnot9node 
   after 1+9:
      l1: 9 -> 7 -> 7 -> 9 -> 1 -> null
    	                            l1
      l2:       2 -> 2 -> 9 -> 9 -> null
    		                         l2
    dummy:  1 -> 0 -> 0 -> 0 -> 9 -> 0
                                    tail
                                    lastnot9node                         
Complexity Analysis :
Time Complexity O(2n+m+k) n is the length of the longer list, m is the length of the shorter list and k is less than n,
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    // step one start
	    int len1 = getLength(l1), len2 = getLength(l2);
	    if(len1 < len2){ // swap l1 and l2 to make sure l1 is the longer one
	        ListNode tmp = l1; l1 = l2; l2 = tmp;
	    }
	    int diff = Math.abs(len1-len2);
	    
	    ListNode dummy = new ListNode(0);
	    ListNode tail = dummy;  //tail is the tail of the new list
	    ListNode lastnot9node = dummy;   
	 // step one end
	 // step two start   
	    while(diff > 0){
	        // create new node
	        tail.next = new ListNode(l1.val);

	        // update lastnot9node
	        if(l1.val != 9) lastnot9node = tail.next;

	        // update tails
	        tail = tail.next;
	        l1 = l1.next;
	        diff--; 
	    }                              
     // step two end
     // step three start
	    while(l1 != null){
	        int val = l1.val + l2.val;
	        
	        if(val >= 10){
	            val -= 10;
	            // update previous nodes
	            lastnot9node.val++;
	            lastnot9node = lastnot9node.next;
	            while(lastnot9node != null){// means there were nodes value 9 after lastnot9node,they need to be set to 0
	                lastnot9node.val = 0;
	                lastnot9node = lastnot9node.next;
	            }
	           // lastnot9node is null now, and  val is not 9, because 9+9=18, so step four is a sure
	        }
	        
	        // create new node
	        tail.next = new ListNode(val);
	        
	        // update lastnot9node
	        if(val != 9) lastnot9node = tail.next; //step four
	        
	        // update tails
	        tail = tail.next;
	        l1   = l1.next;
	        l2   = l2.next;
	    }
	    
	    if(dummy.val == 1) return dummy;
	    return dummy.next;
	}

	private int getLength(ListNode node){
	    int len = 0;
	    while(node != null){
	        len++;
	        node = node.next;
	    }
	    return len;
	}
}

