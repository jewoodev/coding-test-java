package coding.test.leetcode.cannot.hard._403;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{0,1,3,5,6,8,12,17}, true)
        );
    }

    private void test(int[] input, boolean expected) {
        Solution solution = new Solution();
        boolean actual = solution.canCross(input);
        assertEquals(expected, actual);
    }
}