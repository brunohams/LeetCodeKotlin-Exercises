import java.lang.Exception
import kotlin.math.ceil
import kotlin.math.roundToInt

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x in 0..9) {
            return true
        }

        val digits = x.toString()

        // Iterate for half of the array
        for (i in 0..digits.length.ushr(1)) {
            val rightIndex = digits.length-1
            if (digits[i] != digits[rightIndex-i]) {
                return false
            }
        }

        return true
    }

    fun romanToInt(s: String): Int {
        var counter = 0

        val map = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )

        if (s.length == 1) {
            return map[s[0]]!!
        }

        for (index in 1 until s.length step 2) {
            val previous: Int = map[s[index-1]]!!
            val actual: Int = map[s[index]]!!

            counter += if (previous == 1 && actual in listOf(5,10)) {
                actual - previous
            } else if (previous == 10 && actual in listOf(50,100)) {
                actual - previous
            } else if (previous == 100 && actual in listOf(500,1000)) {
                actual - previous
            } else {
                actual + previous
            }
        }

        return counter
    }
}
//
// I -> 1
// II -> 2
// III -> 3
// IV -> 4
// V -> 5
// VI -> 6
// IX -> 9
// X -> 10

// XXIV
// XIV
// IV
// VII

//

//    'I'
//   /   \
//  'V'  'X'
//      /   \
//     'C   'L'
//     / \
//   'D' 'M'
