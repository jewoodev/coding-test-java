package coding.test.leetcode.easy._643;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1,12,-5,-6,50,3}, 4, 12.75000)
        );
    }

    private void test(int[] numArr, int k, double expected) {
        Solution solution = new Solution();
        double actual = solution.findMaxAverage(numArr, k);
        assertEquals(expected, actual);
    }
}