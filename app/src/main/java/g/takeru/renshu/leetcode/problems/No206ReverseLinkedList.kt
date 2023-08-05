package g.takeru.renshu.leetcode.problems

import g.takeru.renshu.leetcode.problems.model.ListNode
import g.takeru.renshu.leetcode.problems.model.printLinkedList
import timber.log.Timber

class No206ReverseLinkedList {

    /**
     * Easy
     *
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     *
     * Hint:
     * A linked list can be reversed either iteratively or recursively. Could you implement both?
     *
     * Example 1:
     * Input: head = [1,2,3,4,5]
     * Output: [5,4,3,2,1]
     *
     * Example 2:
     * Input: head = [1,2]
     * Output: [2,1]
     */

    fun testing () {
        val a = ListNode(1)
        val b = ListNode(2)
        val c = ListNode(3)
        a.next = b
        b.next = c
        c.next = null

        // origin
        a.printLinkedList()
        // reverse
        solution1(a).printLinkedList()
        // reverse again
        solution2(c).printLinkedList()
    }

    fun solution1(head: ListNode?): ListNode? {
        var prev : ListNode? = null
        var curr = head

        while (curr != null) {
            Timber.d("-- curr: ${curr?.value} -> ${curr?.next?.value}" )
            var nextTemp = curr.next
            curr.next = prev
            prev = curr
            curr = nextTemp
            Timber.d("curr: ${curr?.value} -> ${curr?.next?.value}" )
        }

        return prev
    }

    private fun solution2(head: ListNode?): ListNode? {
        if (head?.next == null)
            return head
        val p = solution2(head.next!!)
        head.next?.next = head
        head.next = null
        return p
    }
}