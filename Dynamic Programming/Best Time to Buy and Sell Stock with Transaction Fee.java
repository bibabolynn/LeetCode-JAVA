Problem : 
Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Note:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.

Thought :分成两种情况，一是该天结束后手里没有stock，可能是保持前一天的状态也可能是今天卖出了，此时令收益为cash；二是该天结束后手中有一个stock，可能是保持前一天的状态，也可能是今天买入了，用hold表示。由于第i天的情况只和i-1天有关，所以用两个变量cash和hold就可以

Complexity Analysis :
Time Complexity: O(n),  

Space Complexity: O(1), 


class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);//cash是保持前一天的状态  hold + prices[i] - fee 是卖出，哪个大选哪个
            hold = Math.max(hold, cash - prices[i]); //hold是保持前一天的状态    cash - prices[i]是买入， 
        }
        return cash;
    }
}
