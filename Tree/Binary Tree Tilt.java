Problem: 
Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input: 
         1
       /   \
      2     3
Output: 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
Note:

The sum of node values in any subtree won't exceed the range of 32-bit integer.
All the tilt values won't exceed the range of 32-bit integer.

Thought: it is clear that we need to find the tilt value at every node of the given tree and add up all the tilt values to obtain the final result. To find the tilt value at any node, we need to subtract the sum of all the nodes in its left subtree and the sum of all the nodes in its right subtree.

Complexy:
Time complexity : O(n). where nn is the number of nodes. Each node is visited once.
Space complexity : O(n). In worst case when the tree is skewed depth of tree will be n. In average case depth will be logn.

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
    int tilt=0;
    public int findTilt(TreeNode root) {
        sum(root);
        return tilt;
    }
    public int sum(TreeNode root){
        if(root==null )
            return 0;
        int left=sum(root.left);
        int right=sum(root.right);
        tilt+=Math.abs(left-right);
        return left+right+root.val;
    }
}
