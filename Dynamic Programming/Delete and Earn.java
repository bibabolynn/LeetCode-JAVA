Problem : 
Given an array nums of integers, you can perform operations on the array.

In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn by applying such operations.

Example 1:
Input: nums = [3, 4, 2]
Output: 6
Explanation: 
Delete 4 to earn 4 points, consequently 3 is also deleted.
Then, delete 2 to earn 2 points. 6 total points are earned.
Example 2:
Input: nums = [2, 2, 3, 3, 3, 4]
Output: 9
Explanation: 
Delete 3 to earn 3 points, deleting both 2's and the 4.
Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
9 total points are earned.
Note:

The length of nums is at most 20000.
Each element nums[i] is an integer in the range [1, 10000].

Thought :   
Complexity Analysis :
Time Complexity: O(N+W),
Space Complexity: O(W) the size of count  

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int x: nums) count[x]++;
        int avoid = 0, //the points without using prev
		using = 0, the points using prev
		prev = -1;// previously largest value

        for (int k = 0; k <= 10000; ++k) {
			if (count[k] > 0) {
				int m = Math.max(avoid, using);
				if (k - 1 != prev) { //if k is not adjacent to prev
					using = k * count[k] + m; //the answer if we must take k is (the point value of k) + max(avoid, using)
					avoid = m; // the answer if we must not take k is max(avoid, using).
				} else { // If the new value k is adjacent to the previously largest value prev
					using = k * count[k] + avoid; // the answer if we must take k is (the point value of k) + avoid
					avoid = m; //the answer if we must not take k is max(avoid, using)
				}
				prev = k;
			}
		}
		
        return Math.max(avoid, using);  //the best answer may or may not use the largest value in nums, so we return max(avoid, using)
    }
}


House robber
class Solution {
    public int rob(int[] num) {
	    int rob = 0; //max monney can get if rob current house
	    int notrob = 0; //max money can get if not rob current house
	    for(int i=0; i<num.length; i++) {
	        int currob = notrob + num[i]; //if rob current value, previous house must not be robbed
	        notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
	        rob = currob;
	    }
	    return Math.max(rob, notrob);
	}
}

