package coding.test.leetcode.cannot.Medium._221;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(new char[][]{{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}},
                        4),
                () -> test(new char[][]{{'0','1'}, {'1','0'}},
                        1)
        );
    }

    private void test(char[][] matrix, int expected) {
        Solution solution = new Solution();
        int result = solution.maximalSquare(matrix);
        assertEquals(expected, result);
    }
}