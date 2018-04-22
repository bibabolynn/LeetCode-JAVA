Problem : 
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.

Thought : 

Complexity Analysis :


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
	//层级遍历  广度优先算法（Breadth-First-Search)
	/**
	 * Time complexity : O(n). The whole tree is traversed atmost once. Here, n refers to the 
	 * number of nodes in the given binary tree.

	 * Space complexity : O(m). The size of queue or temp can grow upto atmost the maximum number 
	 * of nodes at any level in the given binary tree. Here, m refers to the maximum mumber of 
	 * nodes at any level in the input tree.
	**/
    public List < Double > averageOfLevels(TreeNode root) {
        List < Double > res = new ArrayList < > ();
        Queue < TreeNode > queue = new LinkedList < > ();
        queue.add(root);
        while (!queue.isEmpty()) {
            long sum = 0, count = 0;
            Queue < TreeNode > temp = new LinkedList < > ();//to store nodes of next level
            while (!queue.isEmpty()) {
                TreeNode n = queue.remove();
                sum += n.val;
                count++;
                if (n.left != null)
                    temp.add(n.left);
                if (n.right != null)
                    temp.add(n.right);
            }
            queue = temp;
            res.add(sum * 1.0 / count);
        }
        return res;
    }


    //Depth First Search
    /**
     * Time complexity : O(n). The whole tree is traversed once only. Here, nn refers to the 
     * total number of nodes in the given binary tree.

	 * Space complexity : O(h). resres and countcount array of size hh are used. Here, h 
	 * refers to the height(maximum number of levels) of the given binary tree. Further, the 
	 * depth of the recursive tree could go upto h only.
     **/
    public List < Double > averageOfLevels(TreeNode root) {
        List < Integer > count = new ArrayList < > ();
        List < Double > res = new ArrayList < > ();
        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / count.get(i));
        return res;
    }
    //i is ith level ; sum is total value of all nodes at this level, count is number of all nodes at this level
    public void average(TreeNode t, int i, List < Double > sum, List < Integer > count) {
        if (t == null)
            return;
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        average(t.left, i + 1, sum, count);
        average(t.right, i + 1, sum, count);
    }
}
