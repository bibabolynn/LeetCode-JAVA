Problem : Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

Thought :  find the mid node,make it root.

Complexity Analysis :Time Complexity O(nlogn), Space complexity O(n),space for TreeNode, nlogn recursive call stack space

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     public TreeNode sortedListToBST(ListNode head) {
        if(head == null ){
            return null;
        }
       return sortedPartListToBST(head,null);
    }
    private TreeNode sortedPartListToBST(ListNode head,ListNode tail) {
        if(head == null || head == tail ){
            return null;
        }
        ListNode slow = head, fast = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedPartListToBST(head,slow);
        root.right = sortedPartListToBST(slow.next,tail);
        return root;
    }
}
