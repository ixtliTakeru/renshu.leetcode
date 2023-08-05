package g.takeru.renshu.leetcode.problems

import java.util.Arrays

class No56MergeIntervals {

    /**
     * Medium
     *
     * Merge Intervals
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping
     * intervals, and return an array of the non-overlapping intervals that cover all the
     * intervals in the input.
     *
     * Example 1:
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     *
     * Example 2:
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     */


    /**
     * 依照start i，從小到大先排序
     * 當下interval的start小於或等於前一個interval的end，表示overlap
     * 當下interval的start大於前一個interval的end，則無overlap
     * 遍歷interval，拿當下的跟前一個比較
     * 有overlap就改動前一個interval的end (注意這種case [[1, 4], [2, 3]])
     * 沒有overlap就把interval加入result裡
     */
    fun solution(intervals: Array<IntArray>): Array<IntArray> {
        val sortedIntervals = intervals.sortedWith( compareBy { it.elementAt(0) } )
        var result: Array<IntArray> = emptyArray()
        var last = 0
        result += sortedIntervals[0]
        for (i in intervals.indices) {
            if (result[last][1] >= sortedIntervals[i][0]) {
                // overlap
                if (result[last][1] < sortedIntervals[i][1]) {
                    result[last][1] = sortedIntervals[i][1]
                }
            } else {
                // not overlap
                result += sortedIntervals[i]
                last++
            }
        }

        return result
    }

    fun solution2(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size <= 1) return intervals

        Arrays.sort(intervals) { i1, i2 -> i1[0].compareTo(i2[0]) }

        val result: MutableList<IntArray> = mutableListOf()
        var newInterval: IntArray = intervals[0]

        for (currentInterval in intervals) {
            if (newInterval[1] >= currentInterval[0]) {
                newInterval[1] = maxOf(newInterval[1], currentInterval[1])
            } else {
                result.add(newInterval)
                newInterval = currentInterval
            }
        }

        result.add(newInterval)

        return result.toTypedArray()
    }
}