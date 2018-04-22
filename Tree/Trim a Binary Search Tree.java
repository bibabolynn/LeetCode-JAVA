Problem : Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
Example 2:
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1

 https://leetcode.com/problems/trim-a-binary-search-tree/description/

Thought : 二叉搜索树，也称有序二叉树,排序二叉树，是指一棵空树或者具有下列性质的二叉树：

1. 若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；

2. 若任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；

3. 任意节点的左、右子树也分别为二叉查找树。

4. 没有键值相等的节点。
Recursion

Complexity Analysis :
Time Complexity: O(N), where N is the total number of nodes in the given tree. We visit each node at most once.

Space Complexity: O(N). Even though we don't explicitly use any additional memory, the call stack of our recursion could be as large as the number of nodes in the worst case.

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
    public TreeNode trimBST(TreeNode root, int L, int R) {
          if(L > R || root == null){
            return null;
          }
   
          if(L > root.val){
             root = trimBST(root.right,L,R);
          }else if(L == root.val){
             root.left = null;
             root.right = trimBST(root.right,root.val, R);
          }else if(L < root.val){
              if(root.val < R){
                  root.left = trimBST(root.left,L, root.val);
                  root.right = trimBST(root.right,root.val, R);
              }else if(root.val == R){ 
                root.left = trimBST(root.left,L, root.val);
                root.right = null;
              }else if(root.val > R){
                  root = trimBST(root.left,L,R);
              }
          }
        return root;
    }

       public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
