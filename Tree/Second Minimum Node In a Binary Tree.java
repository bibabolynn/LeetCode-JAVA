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

Thought: 
compare two potential second minimum value in both subtrees;
if one subnode's value is equal to root.val then we need to find the second minimum value in this subtree as the potential value
else this subnode's vale is a potential second minimum value    
if it's a leaf or a subtree in which every node has same value which equals to root.val then it doesn't have a second minimum value
then the potential second minimum value in the other subtree is the second minimum value; 
return it (if the other subtree doesn't have a potential second minimum value either, then it's -1)



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

        if (left == -1) { //if  left node is a leaf whose value equals to root.val or a right subtree  in which every node has same value which equals to root.val
            return right;//return second minimum value in the other subtree
        }
        if (right == -1) {
            return left;
        }

        return Math.min(left, right);
    }
}


Time Complexity: O(N), where N is the total number of nodes in the given tree. We visit each node exactly once, and scan through the O(N) values in unique once.

Space Complexity: O(N), the information stored in uniques.
class Solution {
    public void dfs(TreeNode root, Set<Integer> uniques) {
        if (root != null) {
            uniques.add(root.val);
            dfs(root.left, uniques);
            dfs(root.right, uniques);
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> uniques = new HashSet<Integer>();
        dfs(root, uniques);

        int min1 = root.val;
        long ans = Long.MAX_VALUE;
        for (int v : uniques) {
            if (min1 < v && v < ans) ans = v;
        }
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }
}


Time Complexity: O(N)O, where N is the total number of nodes in the given tree. We visit each node at most once.

Space Complexity: O(N). The information stored in ans and min1 is O(1), but our depth-first search may store up to O(h)=O(N) information in the call stack, where h is the height of the tree.
class Solution {
    int min1;
    long ans = Long.MAX_VALUE;

    public void dfs(TreeNode root) {
        if (root != null) {
            if (min1 < root.val && root.val < ans) {
                ans = root.val;
            } else if (min1 == root.val) {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        min1 = root.val;
        dfs(root);
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }
}
