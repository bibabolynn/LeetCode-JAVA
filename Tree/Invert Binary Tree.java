Problem: 
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to

     4
   /   \
  7     2
 / \   / \
9   6 3   1

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
class Solution {

Since each node in the tree is visited only once, the time complexity is O(n), where nn is the number of nodes in the tree. We cannot do better than that, since at the very least we have to visit each node to invert it.

Because of recursion, O(h) function calls will be placed on the stack in the worst case, where h is the height of the tree. Because h∈O(n), the space complexity is O(n).
    public TreeNode invertTree(TreeNode root) {
       if(root == null){
          return null;
       }
       if(root.left == null && root.right == null){
         return root;
       }
       TreeNode left = root.left;
       TreeNode right = root.right;
       root.left = invertTree(right);
       root.right = invertTree(left);
       return root;
    }


Since each node in the tree is visited  added to the queue only once, the time complexity is O(n), where n is the number of nodes in the tree.

Space complexity is O(n), since in the worst case, the queue will contain all nodes in one level of the binary tree. For a full binary tree, the leaf level has n/2 nodes =O(n)

    public TreeNode invertTree(TreeNode root) {
	    if (root == null) return null;
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	    while (!queue.isEmpty()) {
	        TreeNode current = queue.poll();
	        TreeNode temp = current.left;
	        current.left = current.right;
	        current.right = temp;
	        if (current.left != null) queue.add(current.left);
	        if (current.right != null) queue.add(current.right);
	    }
   		return root;
	}
}
