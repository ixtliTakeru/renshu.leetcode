package g.takeru.renshu.leetcode.problems

import timber.log.Timber

class No344ReverseString{

    /**
     * Easy
     *
     * Reverse String:
     * Write a function that takes a string as input and returns the string reversed.
     *
     * Example 1:
     * Given s = "hello", return "olleh".
     */

    fun testing () {
        val hello = "hello"
        Timber.d("solution1 : " + solution1(hello))
        Timber.d("solution2 : " + solution2(hello))
        Timber.d("solution3 : " + solution3(hello))
    }

    private fun solution1(x: String): String {
        return StringBuilder(x).reverse().toString()
    }

    private fun solution2(x: String): String {
        var reverseString = ""

        for (i in x.length-1 downTo 0) {
            reverseString += x[i].toString()
        }
        return reverseString
    }

    private fun solution3(x: String): String {
        val length = x.length
        if (length <= 1) return x
        val leftStr = x.substring(0, length / 2)
        val rightStr = x.substring(length / 2, length)
        return solution3(rightStr) + solution3(leftStr)
    }
}