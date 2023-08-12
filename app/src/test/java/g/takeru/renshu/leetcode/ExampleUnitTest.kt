package g.takeru.renshu.leetcode

import g.takeru.renshu.leetcode.problems.No242ValidAnagram
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun no242ValidAnagramTest() {
        val t = "anagram"
        val s = "nagaram"
        val result = No242ValidAnagram().solution1(t, s)
        assertEquals(true, result)
    }
}