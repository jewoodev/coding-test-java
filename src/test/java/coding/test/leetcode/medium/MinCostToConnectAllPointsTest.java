package coding.test.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinCostToConnectAllPointsTest {
    @Test
    void test() {
        int[][] inputs = {
                {0, 0},
                {1, 1},
                {1, 0},
                {-1, 1}
        };
        int output = 4;

        var sut = new MinCostToConnectAllPoints();
        assertThat(sut.minCostConnectPoints(inputs)).isEqualTo(output);
    }
}