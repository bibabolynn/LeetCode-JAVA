Problem: 
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

Thought:  递归
不能直接传StringBuilder 然后append,因为这样会改变原来对象的值，具体关于java传参请见issue
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resList = new LinkedList<String>();
        if(root == null) return resList;//tree is null
        String path = "";
        preOrderTraverse(root, path, resList);//recurrsive
        return resList;
    }
    
    public void preOrderTraverse(TreeNode root, String path, List<String> resList) {
        if(root.left == null && root.right == null) {//leaf node
            path += root.val;
            resList.add(path);//add the 'root to leaf path' to result list
            return;
        }
        path += root.val + "->";//add the root path string
        if(root.left != null) preOrderTraverse(root.left, path, resList);
        if(root.right != null) preOrderTraverse(root.right, path, resList);
    }
}

效率会好一点
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<String>();
        if(root == null) return rst;
        StringBuilder sb = new StringBuilder();
        helper(rst, sb, root);
        return rst;
    }
    
    public void helper(List<String> rst, StringBuilder sb, TreeNode root){
        if(root == null) return;
        int tmp = sb.length();
        if(root.left == null && root.right == null){
            sb.append(root.val);
            rst.add(sb.toString());
            sb.delete(tmp , sb.length());
            return;
        }
        sb.append(root.val + "->");
        helper(rst, sb, root.left);
        helper(rst, sb, root.right);
        sb.delete(tmp , sb.length());
        return;
        
    }
}
