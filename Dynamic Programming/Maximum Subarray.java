Problem : 
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


Thought :    找到包含A[i-1]的 max sum, 然后 如果是小于0的 那 包含 A[i]的 sum 最大的sub array 就是A[i]本身了，然后用 max 和 sum 作比较，更新 max

Complexity Analysis :
Time complexity : O(n).  

Space complexity : O(n).  


class Solution {
	 public int maxSubArray(int[] A) {
	        int n = A.length;
	        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
	        dp[0] = A[0];
	        int max = dp[0];
	        
	        for(int i = 1; i < n; i++){
	            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
	            max = Math.max(max, dp[i]);
	        }
	        
	        return max;
	}
}

class Solution {
	 public int maxSubArray(int[] A) {
        int n = A.length;
      
        int sum = A[0];
        int max = A[0];

        for(int i = 1; i < n; i++){
            int sumWithAi = A[i] + (sum > 0 ? sum : 0);
            sum = sumWithAi;
            max = Math.max(max, sum);
        }

        return max;
	}
}

