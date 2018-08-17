Problem : 
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.

Thought :  Brute Force
Complexity Analysis :
Time Complexity: O(2^n),
Space Complexity: O(n) The depth of the recursion tree can go upto n

public class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }
    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }
}

2D Dynamic Programming

Thought : sum+1000 是因为 sum可能是负的
Suppose we can find out the number of times a particular sum, say sum_i,
​​is possible upto a particular index, say i, in the given numsnums array, which is given by say count_i.
Now, we can find out the number of times the sum sum_i + nums[i] can occur easily as count_i. 
Similarly, the number of times the sum sum_i - nums[i] occurs is also given by count_i.
dp[i][sum+nums[i]]=dp[i][sum+nums[i]]+dp[i−1][sum]
dp[i][sum−nums[i]]=dp[i][sum-nums[i]]+dp[i−1][sum]

Complexity Analysis :
Time Complexity: O(l*n),n refers to the size of numsnums array. l refers to the range of sumsum possible.
Space Complexity: O(l*n) 

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];//0~2000
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) { //不加会有数组越界异常，比如  sum=-1000 sum+1000 = 0,那么如果nums[i] > 0 ，  sum+1000-nums[i]为负数, 但是正常情况 dp[0][0]都会是0，否则，nums[i]（i>0）就都会是0，因为和最大只有1000
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }
}

1D Dynamic Programming

Thought :If we look closely at the last solution, we can observe that for the evaluation of the current row of dp, only the values of the last row of dpdp are needed.

Complexity Analysis :
Time Complexity: O(l*n),n refers to the size of numsnums array. l refers to the range of sumsum possible.
Space Complexity: O(n) 

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[] dp = new int[2001]; 
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {   
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return S > 1000 ? 0 : dp[S + 1000];
    }
}

