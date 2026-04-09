package coding.test.backjoon.bronze;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TriangleAndThreeSidesTest {
    @Test
    void test() {
        String[] input = {
                "7 7 7",
                "6 5 4",
                "3 2 5",
                "6 2 6"
        };
        String[] expected = {
                "Equilateral",
                "Scalene",
                "Invalid",
                "Isosceles"
        };
        var sut = new TriangleAndThreeSides();

        for (int i = 0; i < input.length; i++) {
            assertThat(sut.solution(input[i])).isEqualTo(expected[i]);
        }
    }
}