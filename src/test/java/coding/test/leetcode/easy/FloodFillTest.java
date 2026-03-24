package coding.test.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FloodFillTest {
    @Test
    void test() {
        int[][] image = {
                {0, 0, 0},
                {0, 0, 0},
        };
        int sr = 1, sc = 0, color = 2;
        int[][] expected = {
                {2, 2, 2},
                {2, 2, 2},
        };

        var sut = new FloodFill();
        assertThat(sut.floodFill(image, sr, sc, color)).isEqualTo(expected);
    }
}