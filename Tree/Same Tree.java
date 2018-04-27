Problem: 
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false


Thought: visit right first,then root, then left
Complexy:
Time Complexy: O(n)
Space Complexy :O(n)

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
     public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null ){
          return q == null ? true:false;
        }else{
           return q == null? false: p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right); 
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        Queue<TreeNode> pQ = new LinkedList<TreeNode>();
        Queue<TreeNode> qQ = new LinkedList<TreeNode>();
        pQ.add(p);
        qQ.add(q);
        if(!pQ.isEmpty() && !qQ.isEmpty()){
        	TreeNode pCur = pQ.pop();
        	TreeNode qCur = qQ.pop();
        	if(pCur != null ){
        	  if(qCur == null){
        	    return false;
        	  }else if(pCur.val != qCur.val){
        	    return false;
        	  }else{
        	    pQ.add(pCur.left);
        	    pQ.add(pCur.right);
        	    qQ.add(qCur.left);
        	    qQ.add(qCur.right);
        	  }
        	}else{
        	  if(qCur != null){
        	    return false;
        	  }
        	}
        	
        }
        if(pQ.isEmpty() && qQ.isEmpty()){
         return ture;
        }
        return false;

    }
}
