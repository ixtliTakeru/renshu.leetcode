package g.takeru.renshu.leetcode.problems.model

import timber.log.Timber

class ListNode(var value: Int = 0) {
    var next: ListNode? = null
}

fun printLinkedList(head: ListNode?) {
    var curr = head
    var linkedList = ""
    while (curr != null) {
        linkedList += curr.value.toString() + " -> "
//            Timber.d("curr: ${curr?.value} -> ${curr?.next?.value}")
        curr = curr.next
    }
    linkedList += "null"
    Timber.d(linkedList)
}