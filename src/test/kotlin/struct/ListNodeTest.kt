package struct

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ListNodeTest {

    @Test
    fun testEquals() {
        val first = ListNode(7).apply {
            next = ListNode(0).apply {
                next = ListNode(8)
            }
        }

        val second = ListNode(7).apply {
            next = ListNode(0).apply {
                next = ListNode(8)
            }
        }

        assertEquals(first, second)
    }

    @Test
    fun testSubNodesNotEquals() {
        val first = ListNode(7).apply {
            next = ListNode(0).apply {
                next = ListNode(8)
            }
        }

        val second = ListNode(7).apply {
            next = ListNode(2).apply {
                next = ListNode(1)
            }
        }

        assertNotEquals(first, second)
    }

}