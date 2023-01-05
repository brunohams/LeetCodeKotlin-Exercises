import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LengthOfLongestSubstringTest {

    private val solution = Solution()

    @Test
    fun case1() {
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"))
    }

    @Test
    fun case2() {
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"))
    }

    @Test
    fun case3() {
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"))
    }

    @Test
    fun case4() {
        assertEquals(3, solution.lengthOfLongestSubstring("dvdf"))
    }

    @Test
    fun case5() {
        assertEquals(4, solution.lengthOfLongestSubstring("jbpnbwwd"))
    }

    @Test
    fun case6() {
        assertEquals(1, solution.lengthOfLongestSubstring(" "))
    }

    @Test
    fun case7() {
        assertEquals(2, solution.lengthOfLongestSubstring("aab"))
    }

    @Test
    fun case8() {
        assertEquals(5, solution.lengthOfLongestSubstring("tmmzuxt"))
    }


}


// abcabcbb
// [a: true]
// [b: true]
// [c: true]
// abc
// [a: true]
// [b: true]
// [c: true]
// abc
// [b: true]

// abc

// bbbbb
// [b: true]
// b

// pwwkew
// [p: true]
// [w: true]
// pw
// [w: true]
// w
// [w: true]
// [k: true]
// [e: true]
// wke