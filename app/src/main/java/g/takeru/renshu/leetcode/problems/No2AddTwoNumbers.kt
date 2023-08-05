package g.takeru.renshu.leetcode.problems

import g.takeru.renshu.leetcode.problems.model.ListNode
import g.takeru.renshu.leetcode.problems.model.printLinkedList

class No2AddTwoNumbers {

    /**
     * Medium
     *
     * Add Two Numbers:
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example 1:
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     * Example 2:
     * input: l1 = [0], l2 = [0]
     * Output: [0]
     *
     * Example 3:
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * Output: [8,9,9,9,0,0,0,1]
     */

    fun testing () {
        val a1 = ListNode(2)
        val a2 = ListNode(4)
        val a3 = ListNode(3)

        a1.next = a2
        a2.next = a3
        a3.next = null

        val b1 = ListNode(5)
        val b2 = ListNode(6)
        val b3 = ListNode(4)

        b1.next = b2
        b2.next = b3
        b3.next = null

        var inputA = No206ReverseLinkedList().solution1(a1)
        var inputB = No206ReverseLinkedList().solution1(b1)
        val head = solution1(inputA, inputB)
        head.printLinkedList()
    }

    fun solution1(l1: ListNode?, l2: ListNode?): ListNode? {
        var newHead = ListNode(0)
        var p = l1
        var q = l2
        var curr = newHead

        var carry = 0
        while (p != null && q != null) {
            var pValue = p?.value ?: 0
            var qValue = q?.value ?: 0

            val sum = pValue + qValue + carry
            carry = sum / 10
            curr.next = ListNode(sum % 10)
            curr = curr.next!!

            p = p.next
            q = q.next
        }

        if (carry > 0)
            curr.next = ListNode(carry)

        return No206ReverseLinkedList().solution1(newHead.next)
    }
}