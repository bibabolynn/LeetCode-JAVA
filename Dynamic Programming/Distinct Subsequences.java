Problem : 
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^

Thought :二维动态规划+滚动数组 假设我们现在拥有之前的历史信息，我们怎么在常量操作时间内得到res[i][j]。假设S的第i个字符和T的第j个字符不相同，那么就意味着res[i][j]的值跟res[i-1][j]是一样的，前面该是多少还是多少，而第i个字符的加入也不会多出来任何可行结果。如果S的第i个字符和T的第j个字符相同，那么所有res[i-1][j-1]中满足的结果都会成为新的满足的序列，当然res[i-1][j]的也仍是可行结果，所以res[i][j]=res[i-1][j-1]+res[i-1][j]。所以综合上面两种情况，递推式应该是res[i][j]=(S[i]==T[j]?res[i-1][j-1]:0)+res[i-1][j]。

Complexity Analysis :
Time Complexity: O(m*n),  

Space Complexity: O(m), m是T的长度 


class Solution {
    public int numDistinct(String s, String t) {
        int[] f = new int[t.length() + 1];   //f[j+1]相当于T的前j个字符对应的串
        f[0] = 1;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = t.length() - 1; j >= 0; --j) {   //每次要使用上一行更新前的信息，所以要从后向前，如果是更新后的就要从前向后
                f[j + 1] += s.charAt(i) == t.charAt(j) ? f[j] : 0;
            }
        }

        return f[t.length()];
    }
}
