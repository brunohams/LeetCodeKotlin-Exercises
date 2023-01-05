import org.junit.jupiter.api.Test
import struct.ListNode
import kotlin.test.assertEquals

class AddTwoNumbersTest {

    private val solution = Solution()

    @Test
    fun case1() {
        val listNode1 = ListNode(2).apply {
            next = ListNode(4).apply {
                next = ListNode(3)
            }
        }
        val listNode2 = ListNode(5).apply {
            next = ListNode(6).apply {
                next = ListNode(4)
            }
        }
        val expectedResult = ListNode(7).apply {
            next = ListNode(0).apply {
                next = ListNode(8)
            }
        }
        val result = solution.addTwoNumbers(listNode1, listNode2)

        println(result)
        assertEquals(expectedResult.`val`, result?.`val`)
        assertEquals(expectedResult.next?.`val`, result?.next?.`val`)
        assertEquals(expectedResult.next?.next?.`val`, result?.next?.next?.`val`)
    }

    @Test
    fun case2() {
        val listNode1 = ListNode(0)
        val listNode2 = ListNode(0)
        val expectedResult = ListNode(0)
        val result = solution.addTwoNumbers(listNode1, listNode2)

        println(result)
        assertEquals(expectedResult.`val`, result?.`val`)
        assertEquals(expectedResult.next?.`val`, result?.next?.`val`)
        assertEquals(expectedResult.next?.next?.`val`, result?.next?.next?.`val`)
    }

    @Test
    fun case3() {
        val listNode1 = listToListNode(listOf(9,9,9,9,9,9,9))
        val listNode2 = listToListNode(listOf(9,9,9,9))
        val expectedResult = listToListNode(listOf(8,9,9,9,0,0,0,1))
        val result = solution.addTwoNumbers(listNode1, listNode2)

        printNode(result)

        var nextResult: ListNode? = result
        var nextExpectedResult: ListNode? = expectedResult

        while (nextExpectedResult != null) {
            assertEquals(nextExpectedResult.`val`, nextResult?.`val`)

            nextResult = nextResult?.next
            nextExpectedResult = nextExpectedResult.next
        }
    }

    private fun printNode(result: ListNode?) {
        var nextResult: ListNode? = result

        while (nextResult != null) {
            print("${nextResult.`val`}, ")
            nextResult = nextResult.next
        }
    }


    private fun listToListNode(list: List<Int>): ListNode {
        val root = ListNode(list.first())

        var nextOne = root
        for (i in 1..list.lastIndex) {
            val newNode = ListNode(list[i])
            nextOne.next = newNode
            nextOne = newNode
        }

        return root
    }
}