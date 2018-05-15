Problem : 
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].

Thought :  

Complexity Analysis :
Time complexity : O(n^2). The function construct is called nn times. At each level of the recursive tree, we traverse over all the nn elements to find the maximum element. In the average case, there will be a log(n) levels leading to a complexity of O(nlog(n)). In the worst case, the depth of the recursive tree can grow upto nn, which happens in the case of a sorted numsnums array, giving a complexity of O(n^2).

Space complexity : O(n). The size of the stack can grow upto nn in the worst case. In the average case, the size will be log(n) for n elements in numsnums, giving an average case complexity of O(log(n))



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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
    	if(nums.length == 0){
    	  return null;
    	}
    	return constructTree(nums,0,nums.length-1);
        
    }
    TreeNode constructTree(int[] nums, int low, int high){
        if(low > high){
          return null;
        }
    	int maxIndex = low;
    	int max = nums[low];
    	for(int i = low; i <= high; i++){
    		if(nums[i] > max){
    		    maxIndex = i;
    		    max = nums[i];
    		}
    	}
    	TreeNode root = new TreeNode(nums[maxIndex]);
    	root.left = constructTree(nums,low,maxIndex -1);
    	root.right = constructTree(nums,maxIndex+1,high);
        return root;
    }
    
}
