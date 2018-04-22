package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lynn on 2018/4/22.
 层级
 */

public class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode(int x) { val = x; }
 private static List<TreeNode> nodeList = new ArrayList<TreeNode>();

    public static TreeNode arrayToTree(Integer[] a){
        if(a.length == 0){
            return null;
        }
       for(int i = 0;i<a.length;i++){
           nodeList.add(new TreeNode(a[i]));
       }
       if(nodeList.size() > 0){
           for(int i = 0; i <nodeList.size()/2-1;i++){
               //leftChild
               if(null != nodeList.get(2*i+1)){
                   nodeList.get(i).left = nodeList.get(2*i+1);
               }
               if(null != nodeList.get(2*i+2)){
                   nodeList.get(i).right = nodeList.get(2*i+2);
               }
           }
           //最后一个父子节点不一定有右孩子
           int lastParentIndex = a.length/2-1;
           //左孩子
           nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex*2+1);
           //奇数时候有右孩子
           if(a.length%2 == 1){
               nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex*2+2);
           }
           return nodeList.get(0);
       }
       return null;
    }

    public static void print(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null){
            return;
        }
        TreeNode curr;
        queue.add(root);
        while (!queue.isEmpty()){
            curr= queue.remove();
            System.out.print(" "+curr.val);
            if (curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] a =new Integer[]{1,0,2};
        TreeNode root = arrayToTree(a);
        print(root);
    }
}
