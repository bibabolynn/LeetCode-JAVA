Problem: 
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or
zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:
Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:
Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.

Thought: we need to find the second smallest value in subtree where smaller node is the root node and compare it's value with larger node
if two subnodes have the same value ,then we need to find the second smallest value in both subtree

Complexy:
Time complexity : O(n). 
Space complexity : O(n). 

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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }

        int left = root.left.val;
        if (left == root.val) {
            left = findSecondMinimumValue(root.left);
        }

        int right = root.right.val;
        if (right == root.val) {
            right = findSecondMinimumValue(root.right);
        }

        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }

        return Math.min(left, right);
    }
}
