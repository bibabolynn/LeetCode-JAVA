Problem : 
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


Thought : (Brute Force) [Time Limit Exceeded]

Complexity Analysis :
Time complexity : O(2^n).  Size of recursion tree will be 2^n

Space complexity : O(n). The depth of the recursion tree can go upto n.


class Solution {
    public int climbStairs(int n) {
        if(n<=1) return 1;      
        if(n == 2) return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }
}
Thought :  dp[i]=dp[i−1]+dp[i−2]

Complexity Analysis :
Time complexity : O(n).

Space complexity : O(n). 

public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

Complexity Analysis :
Time complexity : O(n).

Space complexity : O(1). 

public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}

