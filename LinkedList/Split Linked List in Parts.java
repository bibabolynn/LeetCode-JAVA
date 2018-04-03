Problem : Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

Return a List of ListNode's representing the linked list parts that are formed.

Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
Example 1:
Input: 
root = [1, 2, 3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The input and each element of the output are ListNodes, not arrays.
For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but it's string representation as a ListNode is [].
Example 2:
Input: 
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
Note:

The length of root will be in the range [0, 1000].
Each value of a node in the input will be an integer in the range [0, 999].
k will be an integer in the range [1, 50].

Thought : k parts in all, every part needs at lease n nodes，the first i parts need one more node 

Complexity Analysis :
    Time Complexity: O(N + k)O(N+k), where NN is the number of nodes in the given list. If kk is large, it could still require creating many new empty lists.
    Space Complexity: O(k)O(k), the additional space used in writing the answer.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        int len = 0;
        result[0] = root;
        ListNode curr = root;
        while( curr != null){
            curr = curr.next;
            len++;
        }
       int n = len/k, m = len%k;
        curr = root;
        ListNode next = null;
    //一共k个parts 每个parts至少要有n个nodes，i< m 的parts(i starts from o 即前m个parts)要多加一个node 
        for(int i = 0;i<k;i++){
            result[i]=curr;            
            for(int j = 1;j<n+ (i < m? 1:0);j++){// j starts from 1 ,cause i part list already have a node curr,
               if(curr != null){
                   curr = curr.next;
               }
            }
            if(curr != null){
                next = curr.next;// part i+1's head
                curr.next = null;// part i+1's tail points to null
            }else{
                next = null;
            }
            curr = next;
        }
        return result;
    }
}

