Problem : 
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.

Thought : (Brute Force) [Time Limit Exceeded]

Complexity Analysis :
Time complexity : O(n).  

Space complexity : O(1).  


class Solution {
    private int[] data;

	public NumArray(int[] nums) {
	    data = nums;
	}

	public int sumRange(int i, int j) {
	    int sum = 0;
	    for (int k = i; k <= j; k++) {
	        sum += data[k];
	    }
	    return sum;
	}
}


Thought : sumRange 被调用很多，尽量减少它的time complexity 和 space complexity,在创建的时候，把 0到i的sum都存起来

Complexity Analysis :
Time complexity : O(1) time per query, O(n) time pre-computation. Since the cumulative sum is cached, each sumRange query can be calculated in O(1) time.

Space complexity : O(n).


class Solution {
   private int[] sum;  //sum[i] = sumRange(0,i)

	public NumArray(int[] nums) {
	    sum = new int[nums.length + 1];
	    for (int i = 0; i < nums.length; i++) {
	        sum[i + 1] = sum[i] + nums[i];
	    }
	}

	public int sumRange(int i, int j) {
	    return sum[j + 1] - sum[i];
	}
}
