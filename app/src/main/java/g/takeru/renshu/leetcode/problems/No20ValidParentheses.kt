package g.takeru.renshu.leetcode.problems

import timber.log.Timber
import java.util.*

class No20ValidParentheses {

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     *
     * An input string is valid if:
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     *
     * Example 1:
     * Input: s = "()"
     * Output: true
     *
     * Example 2:
     * Input: s = "()[]{}"
     * Output: true
     *
     * Example 3:
     * Input: s = "(]"
     * Output: false
     */
    fun testing() {
        val s1 = "()"
        Timber.d("s1 isValid: ${solution(s1)}")
        val s2 = "()[]{}"
        Timber.d("s2 isValid: ${solution(s2)}")
        val s3 = "(]"
        Timber.d("s3 isValid: ${solution(s3)}")
    }

    private fun solution(s: String): Boolean {
        // check string length
        val map = mutableMapOf<Char, Char>()
        map['}'] = '{'
        map[']'] = '['
        map[')'] = '('

        // use stack
        val stack = Stack<Char>()
        s.toCharArray().forEach{
            if(map.containsKey(it)){
                // check stack.top is "(", "[", "{" or not, when char is ")", "]", "}"
                if(stack.isEmpty() || map[it] != stack.pop())
                    return false
            } else {
                // push it, when char is "(", "[", "{"
                stack.push(it)
            }
        }

        // if stack is empty, it means valid
        return stack.empty()
    }
}