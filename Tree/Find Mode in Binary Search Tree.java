Problem: 
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

Thought: 中序遍历，所有值一样的节点都挨在一起，计算相同值的节点的个数，count++,  bst想到中序遍历

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class Solution{
 	public int[] findMode(TreeNode root) {
        List<Integer> modes = new LinkedList<>();//当前出现最频繁的nodes
        if(root == null) return new int[]{};
        findMode(root, modes);
        int[] res = new int[modes.size()];
        int i=0;
        for(int m : modes) res[i++] = m;
        return res;
    }
    int maxCount = 1, count = 1;
    Integer prev = null; //中序遍历的上一个节点
    private void findMode(TreeNode root, List<Integer> modes){
        if(root == null) return;
        findMode(root.left, modes);
        if(prev != null && prev == root.val)
            ++count;
        else
            count = 1;
        if(maxCount <= count){
            if(maxCount < count){//说明有出现更频繁的节点，把之前的节点清空
                modes.clear();
            	maxCount = count;
            }
            
            modes.add(root.val);
            
        }
        prev = root.val;
        findMode(root.right, modes);
    }
 }
