package coding.test.leetcode.cannot.medium._394;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test("3[a]2[bc]", "aaabcbc"),
                () -> test("3[a2[c]]", "accaccacc"),
                () -> test("2[abc]3[cd]ef", "abcabccdcdcdef")
        );
    }

    private void test(String input, String expected) {
        Solution solution = new Solution();
        String actual = solution.decodeString(input);
        assertEquals(expected, actual);
    }
}