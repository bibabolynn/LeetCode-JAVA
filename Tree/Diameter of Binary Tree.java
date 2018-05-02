Problem : 
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

Thought : 

Complexity Analysis :
Time Complexity: O(n)
Space Complexity: O(n)


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
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans ;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R);//比较当前值和新值，取大的
        return Math.max(L, R) + 1;
    }
}

class Solution {

//这个，两个递归，不好
    public int diameterOfBinaryTree(TreeNode root) {
      if(root == null ){
       return 0;
      }
     return  Math.max(Math.max( diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)),getH(root.left)+getH(root.right));
    }
    public int getH(TreeNode root){
      if(root == null){
        return 0;
      }
      return 1+Math.max(getH(root.left),getH(root.right));
    }
}
