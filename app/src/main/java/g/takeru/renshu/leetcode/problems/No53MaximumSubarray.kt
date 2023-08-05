package g.takeru.renshu.leetcode.problems

import timber.log.Timber
import kotlin.math.max

class No53MaximumSubarray {

    /**
     * Medium
     *
     * Maximum Subarray:
     * Given an integer array nums, find the subarray with the largest sum, and return its sum.
     *
     * Example 1:
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     *
     * Example 2:
     * Input: nums = [1]
     * Output: 1
     * Explanation: The subarray [1] has the largest sum 1.
     *
     * Example 3:
     * Input: nums = [5,4,-1,7,8]
     * Output: 23
     * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
     */

    fun testing() {
        val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
        val result = solution(nums)
        Timber.d("Result: $result")
    }

    /**
     * 找出加總最大值的subarray
     * 運用累積值(curSum)跟最大值(maxSum)
     * 每次遍歷的時候累積值跟最大值比較
     * 如果下一個值大於累積值，取代累積值；如果下一個值小於累積值，累積值不變
     * 如果最大值大於累積值，最大值不變；如果最大值小於累積值，取代最大值
     *
     * TC: O(N) 一個for loop
     * SC: O(1) 沒有用到任何的data structure，所以是常數1
     */
    private fun solution(nums: IntArray): Int {
        var curSum = 0
        var maxSum = nums[0]
        for (i in nums.indices) {
            curSum += nums[i]
            curSum = maxOf(curSum, nums[i])
            maxSum = maxOf(curSum, maxSum)
        }
        return maxSum
    }
}