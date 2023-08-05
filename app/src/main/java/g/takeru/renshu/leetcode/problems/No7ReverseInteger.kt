package g.takeru.renshu.leetcode.problems

import timber.log.Timber
import kotlin.math.abs

/**
 * Created by takeru on 2018/3/13.
 */
class No7ReverseInteger {

    /**
     * Medium
     *
     * Reverse Integer:
     * Given a signed 32-bit integer x, return x with its digits reversed.
     *
     * Example 1:
     * Input: 123
     * Output:  321
     *
     * Example 2:
     * Input: -123
     * Output: -321
     *
     * Example 3:
     * Input: 120
     * Output: 21
     */

    // hint: using long to save 32-bit integer

    fun testing() {
        var result = No7ReverseInteger().solution2(123)
        Timber.d("solution1 : $result")
        result = No7ReverseInteger().solution1(-123)
        Timber.d("solution2 : $result")
        result = No7ReverseInteger().solution2(120)
        Timber.d("solution3 : $result")
    }

    fun solution1(x: Int): Int {
        val sign = if (x > 0) 1 else -1
        val originString : String = abs(x).toString()
        val reverseString = StringBuilder(originString).reverse().toString()
        val reverseNum = reverseString.toLong() * sign

        if (reverseNum > Integer.MAX_VALUE || reverseNum < Integer.MIN_VALUE) {
            return 0
        } else {
            return reverseNum.toInt()
        }
    }

    private fun solution2(y: Int): Int {
        var result = 0
        var x = y

        while (x != 0) {
            Timber.d("-- while start")
            val tail = x % 10
            val newResult = result * 10 + tail
            Timber.d("tail $tail, result $result, newResult $newResult")

            if ((newResult - tail) / 10 != result)
                return 0

            result = newResult
            x /= 10
        }

        return result
    }
}