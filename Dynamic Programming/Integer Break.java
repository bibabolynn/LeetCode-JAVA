Problem : 
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.

Thought :

Complexity Analysis :
Time Complexity: O(n/3),  

Space Complexity: O(n/3), 


class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int mul = 0;
        return helper(n);
    }
    private int helper(int n){
        if (n == 2) return 2;
        if (n == 3) return 3;
        if (n == 4) return 4;
        return helper(n - 3) * 3; 
    }
}
Time Complexity: O(n^2),  

Space Complexity: O(n), 
class Solution {
    public int integerBreak(int n) {
      int[] dp = new int[n + 1];
        dp[0] = 1;
        int max = 0;
        for(int i = 1; i < n; i++){
            for(int j = i; j <= n; j++){
                dp[j] = Math.max(dp[j], dp[j - i] * i);
                if(j == n){  //更新max
                    if(max < dp[j])
                        max = dp[j];
                }
            }
        }
        return max;
    }
    
}
