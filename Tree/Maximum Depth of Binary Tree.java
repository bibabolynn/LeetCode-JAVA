Problem : 
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.



Thought : 递归

Complexity Analysis :
Time Complexity: O(N),N is the total number of nodes in tree
Space Complexity: 0(h),h is the max depth of the tree


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        return root==null? 0 : Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
