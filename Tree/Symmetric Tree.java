Problem: 
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

Thought:  虽然思想一样，但是写法不一样，程序跑出来时间和空间的利用率就不一样，下面四个解法，前两个是递归，后两个是迭代，
两组里第一个都是我写的，第二个是答案里的，我写的只展示百分之16多，但是答案战胜百分之82多

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
    public boolean isSymmetric(TreeNode root) {
       if(root == null){
        return true;
       }
       return isMirror(root.left,root.right);

    }
    public boolean isMirror(TreeNode left, TreeNode right){
    	if(left == null && right == null){
    	  return true;
    	}else if(left == null || right == null){
    	  return false;
    	}else if(left.val != right.val){
    	  return false;
    	}
    	return isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }
}

public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
}

public boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val)
        && isMirror(t1.right, t2.left)
        && isMirror(t1.left, t2.right);
}


class Solution {
    public boolean isSymmetric(TreeNode root) {
       if(root == null){
        return true;
       }
      List<TreeNode> list = new ArrayList<TreeNode>();
      list.add(root);
      while(!list.isEmpty()){
          List<TreeNode> firstHalf = new ArrayList<TreeNode>();
           List<TreeNode> secondHalf = new ArrayList<TreeNode>();
         for(int i = 0;i<=list.size()/2;i++){
                TreeNode head = list.get(i);
                TreeNode tail = list.get(list.size()-i-1);
                if(head == null && tail == null){
                  continue;
                }else if(head == null || tail == null){
                 return false;
                }else if(head.val != tail.val){
                  return false;
                }
                firstHalf.add(head.left);
                firstHalf.add(head.right);
                secondHalf.add(0,tail.right);
                secondHalf.add(0,tail.left);
          }
           firstHalf.addAll(secondHalf);
          list =firstHalf;
      }
      return true;  
    }
}

public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
}
