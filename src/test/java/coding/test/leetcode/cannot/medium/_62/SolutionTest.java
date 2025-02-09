package coding.test.leetcode.cannot.medium._62;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void test() {
        Solution solution = new Solution();
        assertThat(solution.uniquePaths(3, 7)).isEqualTo(28);
        assertThat(solution.uniquePaths(3, 2)).isEqualTo(3);
    }
}