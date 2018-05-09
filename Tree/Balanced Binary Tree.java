Problem: 
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 Thought: 自己本身左子树的height和右子树的height相差不超过1，并且左右子树都是balanced tree;
Complexy:
Time complexity : O(n^2).For the current node root, calling depth() for its left and right children actually has to access all of its children, thus the complexity is O(N). We do this for each node in the tree, so the overall complexity of isBalanced will be O(N^2) 
Space complexity : O(h^2). 
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(getHeight(root.left)-getHeight(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
}

Thought: when a subTree is not a balanced tree, return -1, 一直到最后一个递归，不去检查别的子树了
Time complexy O(n)
space complexy O(h)
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return getHeight(root) != -1;
    }
    int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftH = getHeight(root.left);
        if(leftH == -1)
           return -1;
        int rightH = getHeight(root.right);
        if(rightH == -1)
           return -1;
        if(Math.abs(leftH-rightH)>1){
          return -1;
        }
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
}
