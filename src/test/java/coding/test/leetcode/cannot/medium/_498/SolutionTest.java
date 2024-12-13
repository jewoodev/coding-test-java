package coding.test.leetcode.cannot.medium._498;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;


class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(
                        new int[][]{{1,2,3},{4,5,6},{7,8,9}},
                        new int[]{1,2,4,7,5,3,6,8,9}
                )
        );
    }

    private void test(int[][] input, int[] expected) {
        Solution solution = new Solution();
        int[] actual = solution.findDiagonalOrder(input);
        assertThat(actual).isEqualTo(expected);
    }
}