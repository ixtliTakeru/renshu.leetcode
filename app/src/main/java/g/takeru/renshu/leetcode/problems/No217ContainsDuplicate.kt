package g.takeru.renshu.leetcode.problems

class No217ContainsDuplicate {

    /**
     * Easy
     *
     * Contains Duplicate:
     * Given an integer array nums, return true if any value appears at least twice in the array,
     * and return false if every element is distinct.
     *
     * Example 1:
     * Input: nums = [1,2,3,1]
     * Output: true
     *
     * Example 2:
     * Input: nums = [1,2,3,4]
     * Output: false
     *
     * Example 3:
     * Input: nums = [1,1,1,3,3,4,3,2,4,2]
     * Output: true
     */

    fun testing() {
        val nums = intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)
        val result1 = solution1(nums)
        val result2 = solution2(nums)
        val result3 = solution3(nums)
    }

    /**
     * 暴力解：
     * TC: O(N^2)
     * SC: 0(1)
     *
     * sorting解：
     * TC: O(N log N)
     * SC: 0(N)
     *
     * Set解：
     * TC: O(N)
     * SC: 0(N)
     * Set的特性，不會儲存重複的值
     */
    private fun solution1(nums: IntArray): Boolean {
        for (i in nums.indices) {
            for (j in i+1 until nums.size) {
                if (nums[i] == nums[j])
                    return true
            }
        }
        return false
    }

    private fun solution2(nums: IntArray): Boolean {
        nums.sort()
        for (i in 0 until nums.size -1) {
            if (nums[i] == nums[i+1])
                return true
        }
        return false
    }

    private fun solution3(nums: IntArray): Boolean {
        val set = nums.toSet()
        return (nums.size != set.size)
    }

}