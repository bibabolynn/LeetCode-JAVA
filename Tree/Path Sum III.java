Problem : 
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

Thought : 

Complexity Analysis :
Time Complexity: O(n^2) in worst case (no branching); O(nlogn) in best case (balanced tree).
pathSumFrom takes O(n)
pathSum has recurrence relation T(n) = n + 2T(n/2) = nlogn for balance tree.
pathSum has recurrence relation T(n) = n + T(n-1) = n^2 for linear tree.
Space Complexity: O(n) due to recursion.


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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);//path 包含当前节点和path不包含当前节点（不包含的又可以从左子树找，或者从右子树找）
    }
    
    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) //node.val == sum  说明我们已经找到了一条
            + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);//继续找下去是因为可能下面的子节点的值可能相加为0
    }
}
