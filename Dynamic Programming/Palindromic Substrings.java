Problem : 
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

方法1
Thought : 以字符串中的每一个字符都当作回文串中间的位置，然后向两边扩散，每当成功匹配两个左右两个字符，结果res自增1，然后再比较下一对。注意回文字符串有奇数和偶数两种形式，如果是奇数长度，那么i位置就是中间那个字符的位置，所以我们左右两遍都从i开始遍历；如果是偶数长度的，那么i是最中间两个字符的左边那个，右边那个就是i+1

Complexity Analysis :
Time complexity : O(n^2).  
Space complexity : O(1).  

class Solution {
    public int countSubstrings(String s) {
         if (s.isEmpty()) return 0;
        int n = s.length(), res = 0;
        for (int i = 0; i < n; ++i) {
            res+=helper(s, i, i);
            res+=helper(s, i, i + 1);
        }
        return res;
    }
    private int helper(String s, int i, int j) {
        int res = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            --i; ++j; ++res;
        }
        return res;
    }
}

方法2：Manacher's Algorithm
Thought:
  /**
	to explain Z[i] = Math.min(right - i, Z[2 * center - i]); https://www.felix021.com/blog/read.php?2040
    记j = 2 * center - i，也就是说 j 是 i 关于 center 的对称点(j = center - (i - center))
    if (right - i > Z[j])    当 right - i > Z[j] 的时候，以A[j]为中心的回文子串包含在以A[center]为中心的回文子串中，由于 i 和 j 对称，以A[i]为中心的回文子串必然包含在以A[center]为中心的回文子串中，所以必有 Z[i] = Z[j]
     	Z[i] = Z[j];
    else  当 Z[j] >= right - i 的时候，以A[j]为中心的回文子串不一定完全包含于以A[center]为中心的回文子串中，但是基于对称性可知，以A[i]为中心的回文子串，其向右至少会扩张到right的位置，也就是说 Z[i] >= right - i。至于right之后的部分是否对称，就只能老老实实去匹配了。 

    	Z[i] = right - i; // Z[i] >= right - i，取最小值，之后再匹配更新。

 */

Complexity Analysis :
Time complexity : O(n).  where n is the length of S
Space complexity : O(n).  the size of A and Z.

class Solution {
    public int countSubstrings(String S) {
        char[] A = new char[2 * S.length() + 3];
        A[0] = '@';
        A[1] = '#';  
        A[A.length - 1] = '$'; //可以在字符串的开始和结尾加入另一个特殊字符，这样就不用特殊处理越界问题
        int t = 2;
        for (char c: S.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';//每个字符后面都加#，这样无论奇数偶数字符串，都会变成奇数字符串
        }

        int[] Z = new int[A.length];//来记录以字符A[i]为中心的最长回文子串向左/右扩张的长度,只有本身，则长度为1
        int center = 0, right = 0;//center已知的 {右边界最大} 的回文子串的中心   right则为这个子串的右边界
        for (int i = 1; i < Z.length - 1; ++i) {
      
            if (i < right)
                Z[i] = Math.min(right - i, Z[2 * center - i]);//>=right-i, =Z[j],半径小的那个，是确定对称的
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1])//向外循环验证，the while loop only checks the condition more than once when Z[i] = right - i.because if Z[i]=Z[j] ,等式就不会成立，就会跳出来   In that case, for each time Z[i] += 1, it increments right, and right can only be incremented up to 2*N+2 times. 因为right是半径，半径最长就是字符串的长度了
                Z[i]++;
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int ans = 0;
        for (int v: Z) ans += (v + 1) / 2; //We are dividing by 2 because we were using half-lengths instead of lengths. For example we actually had the palindrome a#b#c#d#e#d#c#b#a, so our length is twice as big.
        return ans;
    }
}
