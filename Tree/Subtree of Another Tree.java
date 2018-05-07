Problem: 
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.

Thought: 

Complexy:
 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


 Time complexity : O(m*n). In worst case(skewed tree) traverse function takes O(m*n) time. m nodes of tree t,n nodes of the tree ss

Space complexity : O(n). The depth of the recursion tree can go upto n. n refers to the number of nodes in s.

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null){
          return true;
        }
        if(s == null || t == null){
          return false;
        }

        if(s.val != t.val){
            return isSubtree(s.left,t) || isSubtree(s.right,t);
        }
        return isSameTree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    public boolean isSameTree(TreeNode s, TreeNode t){
       if(s == null && t == null){
          return true;
        }
        if(s == null || t == null){
          return false;
        }

        if(s.val != t.val){
            return false;
        }
        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }
}


public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    public boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }
    public boolean traverse(TreeNode s,TreeNode t)
    {
        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }
}


We can find the preorder traversal of the given tree s and t, given by, say and t preorder respectively(represented in the form of a string). Now, we can check if t preorder is a substring of s preorder
But, in order to use this approach, we need to treat the given tree in a different manner. Rather than assuming a null value for the childern of the leaf nodes, we need to treat the left and right child as a lnull and rnull value respectively. This is done to ensure that the t preorder doesn't become a substring of s ​preorder
​​  even in cases when t isn't a subtree of s.

You can also note that we've added a '#' before every considering every value. If this isn't done, the trees of the form s:[23, 4, 5] and t:[3, 4, 5] will also give a true result since the preorder string of the t("23 4 lnull rull 5 lnull rnull") will be a substring of the preorder string of s("3 4 lnull rull 5 lnull rnull"). Adding a '#' before the node's value solves this problem.

Time complexity : O(m^2+n^2+m*n). A total of n nodes of the tree s and m nodes of tree t are traversed. Assuming string concatenation takes O(k) time for strings of length k and indexOf takes O(m*n).

Space complexity : O(max(m,n)). The depth of the recursion tree can go upto n for tree t and m for tree s in worst case.


public class Solution {
    HashSet < String > trees = new HashSet < > ();
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preorder(s, true);
        String tree2 = preorder(t, true);
        return tree1.indexOf(tree2) >= 0;
    }
    public String preorder(TreeNode t, boolean left) {
        if (t == null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }
        return "#"+t.val + " " +preorder(t.left, true)+" " +preorder(t.right, false);
    }
}
