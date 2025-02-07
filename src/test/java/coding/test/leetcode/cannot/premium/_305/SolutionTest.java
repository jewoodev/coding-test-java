package coding.test.leetcode.cannot.premium._305;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void test() {
        Solution solution = new Solution();
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        assertThat(solution.numIslands2(3, 3, positions)).isEqualTo(new int[]{1, 1, 2, 3});
    }
}