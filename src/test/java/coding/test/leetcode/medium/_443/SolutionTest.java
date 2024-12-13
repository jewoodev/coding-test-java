package coding.test.leetcode.medium._443;

import coding.test.leetcode.cannot.medium._443.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(
                        new char[]{'a','a','b','b','c','c','c'},
                        6
                )
        );
    }

    private void test(char[] chars, int expected) {
        Solution solution = new Solution();
        int actual = solution.compress(chars);
        assertEquals(expected, actual);
    }
}