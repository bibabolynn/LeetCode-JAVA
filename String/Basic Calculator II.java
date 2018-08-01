Problem : 
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.


Thought : 因为可能有 * / ，所以要保留两个数字和一个符号， 如果遇到加减，那么第一个数字就可以加到结果中，我们看第二个数字和下一个数字产生什么运算，
如果还是加减，就又可以把头一个数字加到结果中，如果是乘除，那么要立即计算成一个数字，因为是最高优先级了


Complexity Analysis :
Time Complexity: O(N),
Space Complexity: O(1)

class Solution {
     public static int calculate(String s) {
        char[] c = s.toCharArray();
        int num = 0; //current number
        int preNum = 0; // pre number
        int res = 0;  //result
        char sign = '+';
        int i = 0;
        while( i < c.length){
            num = 0;
            while(c[i] == ' '){
                ++i;
            }
            while(i < c.length && Character.isDigit(c[i])){
                num = num * 10 + (c[i] - '0');
                ++i;
            }
            if('+' == sign){
                res += preNum;
                preNum = num;
            }else if('-' == sign){
                res += preNum;
                preNum = -num;
            }else if('*' == sign){
                preNum = preNum * num;
            }else if('/' == sign){
                preNum = preNum / num;
            }
            if(i < c.length){
                sign = c[i];
                ++i;
            }
        }

        res += preNum;
		return res;
    }
}
