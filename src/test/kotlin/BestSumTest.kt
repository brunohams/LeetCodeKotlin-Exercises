import org.junit.jupiter.api.Test
import struct.TreeNode
import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BestSumTest {

    private val solution = Solution()

    @Test
    fun tests_memoized() {
        assertEquals(
            listOf(7),
            solution.bestSumMemoized(7, listOf(5, 3, 4, 7))
        )
        assertEquals(
            listOf(5,3),
            solution.bestSumMemoized(8, listOf(2,3,5))
        )
        assertEquals(
            listOf(4,4),
            solution.bestSumMemoized(8, listOf(1,4,5))
        )
        println(solution.howManyReais(545.36f, listOf(0.01f, 0.05f, 0.1f, 0.25f, 0.50f, 1f, 2f,5f,10f,20f,50f,100f,200f)))
//        assertEquals(
//            listOf(25,25,25,25),
//            solution.bestSumMemoized(100, listOf(1,2,5,25))
//        )
    }

    @Test
    fun tests_tabulation() {
        assertEquals(
            listOf(7),
            solution.bestSumTabulation(7, listOf(5, 3, 4, 7))
        )
        assertEquals(
            listOf(5,3),
            solution.bestSumTabulation(8, listOf(2,3,5))
        )
        assertEquals(
            listOf(4,4),
            solution.bestSumTabulation(8, listOf(1,4,5))
        )


        val target = 9_99
        val result = solution.bestSumTabulation(target, listOf(1, 5, 10, 25, 50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000))
        println((target.toFloat() / 100).toBigDecimal().formataParaBr())
        println("-------")
        result?.forEach {
            println((it.toFloat() / 100).toBigDecimal().formataParaBr())
        }
    }

}

fun BigDecimal.formataParaBr() : String {
    val moeda = DecimalFormat.getCurrencyInstance(Locale("pt", "BR"))
    return moeda.format(this).replace(moeda.currency.currencyCode, moeda.currency.currencyCode + " ")
}