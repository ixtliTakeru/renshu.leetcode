package g.takeru.renshu.leetcode.problems

class No242ValidAnagram {

    /**
     * Easy
     *
     * Valid Anagram:
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or
     * phrase, typically using all the original letters exactly once.
     *
     * Example 1:
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     *
     * Example 2:
     * Input: s = "rat", t = "car"
     * Output: false
     */

    fun testing() {
        val t = "anagram"
        val s = "nagaram"
        solution1(t, s)
        solution2(t, s)
    }

    /**
     * sorting法：
     * TC: O(N log N)
     * SC: O(N)
     *
     * Map法：
     * 建立一個HashMap，key是字母，value是出現的次數
     * 把s的字母一個個放入，重複的話value + 1
     * 再針對t的字母，把value-1
     * 如果s跟t是Anagram，HashMap的所有value都會是0
     * TC: O(N)
     * SC: O(N)
     *
     * List法：
     * 把S轉乘string list
     * 再針對t的字母，如果有在list裡，移除它
     * 如果s跟t是Anagram，list size將會是0
     */
    fun solution1(t: String, s: String): Boolean {
        if (t.length != s.length) return false
        return s.toList().sorted() == t.toList().sorted()
    }

    private fun solution2(t: String, s: String): Boolean {
        if (t.length != s.length) return false

        // Create hashmap to record char and count
        val map: MutableMap<Char, Int> = mutableMapOf()
        // For every character in s, increment count by 1
        s.forEach { map[it] = map.getOrDefault(it, 0) + 1 }
        // For every character in t, decrement count by 1
        t.forEach { map[it] = map.getOrDefault(it, 0) - 1 }
        // Filter all elements in freqMap where count is not 0 and return if there are more than 0 characters left
        return map.filter { it.value != 0 }.isEmpty()
    }

    private fun solution3(t: String, s: String): Boolean {
        val charList = t.toMutableList()
        for (char in s)  {
            if (!charList.remove(char)) return false
        }
        return charList.size == 0
    }
}