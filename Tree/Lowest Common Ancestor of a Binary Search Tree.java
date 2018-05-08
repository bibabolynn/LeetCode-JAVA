Problem: 
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
Example 1:

Input: root, p = 2, q = 8
Output: 6 
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:

Input: root, p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself 
             according to the LCA definition.
Thought: 如果在root的两边或者有一个等于root的值，那么就是root
如果都小于root的值就去左子树找，如果都大于root的值就去右子树找

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root == null || p == null || q == null){
    	   return null;
    	}
        if((p.val <= root.val && q.val >= root.val)||(p.val >= root.val && q.val <= root.val)){
          return root;
        }
        if(p.val <root.val && q.val <root.val){
          return lowestCommonAncestor(root.left,p,q);
        }
        if(p.val > root.val && q.val > root.val){
          return lowestCommonAncestor(root.right,p,q);
        }
    }
}
