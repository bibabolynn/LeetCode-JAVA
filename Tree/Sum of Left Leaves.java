Problem: 
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.


Thought: 写一个新方法，参数传一个布尔值  表示当前节点是否是左节点，return value of node if node is a left leaf node,else return 0
Complexy:
Time Complexy: O(n)，每个节点都要到达一次
Space Complexy :O(n),递归，如果是个左斜树或者右斜树，需要用到n个空间

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
    public int sumOfLeftLeaves(TreeNode root) {
        return  sum(root,false);
    }

    public int sum(TreeNode root,boolean sumIfNull){
       if(root == null){
         return 0;
       }
       //return value of node if node is a left leaf node,else return 0
       if(root.left == null && root.right == null){
         return sumIfNull ? root.val : 0;
       }
       
         return sum(root.left, true) + sum(root.right,false);
       
    }
}


public int sumOfLeftLeaves(TreeNode root) {
    if(root == null) return 0;
    int ans = 0;
    if(root.left != null) {
        if(root.left.left == null && root.left.right == null) ans += root.left.val;
        else ans += sumOfLeftLeaves(root.left);
    }
    ans += sumOfLeftLeaves(root.right);
    
    return ans;
}

public int sumOfLeftLeaves(TreeNode root) {
    if(root == null) return 0;
    int ans = 0;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    
    while(!stack.empty()) {
        TreeNode node = stack.pop();
        if(node.left != null) {
            if (node.left.left == null && node.left.right == null)
                ans += node.left.val;
            else
                stack.push(node.left);
        }
        if(node.right != null) {
            if (node.right.left != null || node.right.right != null)
                stack.push(node.right);
        }
    }
    return ans;
}
