Problem : 
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])



Thought :一个排列组合的题目，让求没有重复数字的数的个数，学过概率论的应该很容理解．当n=1时因为只有一个数字，所以0-9都是答案．当n>=2时，最高位可以为1-9任意一个数字，之后各位可以选择的数字个数依次为9, 8, 7, 6...，上一位选一个下一位就少了一种选择．

Complexity Analysis :
Time Complexity: O(n),  

Space Complexity: O(1), 


class Solution {
    public int countNumbersWithUniqueDigits(int n) {
         if(n==0) return 1;  
        if(n==1) return 10;  
        int val = 9, ans = 10;  
        for(int i = 2; i <= n; i++)  {  
            val *= (9-i+2);  
            ans += val;  
        }  
        return ans;  
    }
}
