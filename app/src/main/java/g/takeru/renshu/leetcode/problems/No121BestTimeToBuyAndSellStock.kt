package g.takeru.renshu.leetcode.problems

class No121BestTimeToBuyAndSellStock {

    /**
     * Easy
     *
     * Best Time To Buy And Sell Stock:
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a
     * different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any
     * profit, return 0.
     *
     * Example 1:
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     *
     * Example 2:
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transactions are done and the max profit = 0.
     */

    fun testing() {
        val prices = intArrayOf(7, 1, 5, 3, 6, 4)
        solution1(prices)
    }

    /**
     * 暴力法：
     * 遍歷每一天，用後面的價錢減去前面的，紀錄最大值
     * TC: O(N^2)
     * SC: O(1)
     *
     * One pass法：
     * 遍歷時，持續記錄minPrice跟maxProfit
     * maxProfit 為當下的price減去minPrice再跟maxProfit比
     * minPrice 為當下的price與minPrice比
     * TC: O(N)
     * SC: O(1)
     */

    private fun solution1(prices: IntArray): Int {
        var minPrice = prices[0]
        var maxProfit = 0
        for (price in prices) {
            minPrice = minOf(minPrice, price)
            maxProfit = maxOf(maxProfit,  price - minPrice)
        }
        return maxProfit
    }
}