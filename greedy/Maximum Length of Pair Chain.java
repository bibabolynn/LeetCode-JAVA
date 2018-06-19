Problem : 
You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

Example 1:
Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]
Note:
The number of given pairs will be in the range [1, 1000].

Thought :后面链对的首元素大于前链对的末元素  Greedy

 

Complexity Analysis :
Time Complexity: O(NlogN),  排序

Space Complexity: O(N), 排序 


class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]); //按尾元素排序，从小到大
        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] pair: pairs) //pair是有连个元素的一维数组
         if (cur < pair[0]) {//尾元素小于当前链对的首元素，这个链对可以链上去
            cur = pair[1];
            ans++;
       	 }
        return ans;
    }
}
