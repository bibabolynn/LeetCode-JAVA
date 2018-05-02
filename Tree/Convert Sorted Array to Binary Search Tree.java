Problem : 
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

Thought : 二分法

Complexity Analysis :
Time Complexity: O(n)
Space Complexity: O(logn)


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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
          return null;
        }
        return arrayToTree(nums,0,nums.length-1) ;

    }
    public TreeNode arrayToTree(int[] nums,int low,int high){
         if(low > high){
          return null;
         }
         int mid = (low+high)/2;
         TreeNode root = new TreeNode(nums[mid]);
         root.left = arrayToTree(nums,low,mid-1);
         root.right = arrayToTree(nums,mid+1,high);
         return root;
    }
}
