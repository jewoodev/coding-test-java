package coding.test.backjoon.bronze;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Zoac4Test {
    @Test
    void test() {
        int[] input = {5, 4, 1, 1};

        var sut = new Zoac4();

        assertThat(sut.solution(input)).isEqualTo(6);
    }
}