package coding.test.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinCostToConnectAllPointsTest {
    @Test
    void test() {
        int[][] inputs = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };
        int output = 20;

        var sut = new MinCostToConnectAllPoints();
        assertThat(sut.minCostConnectPoints(inputs)).isEqualTo(output);
    }
}