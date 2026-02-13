package coding.test.besuccessfulapplicants.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FailureRateTest {
    @Test
    void test() {
        int[] N = {5,4};
        int[][] stages = {
                {2,1,2,6,2,4,3,3},
                {4,4,4,4,4}
        };
        int[][] result = {
                {3,4,2,1,5},
                {4,1,2,3}
        };

        var sut = new FailureRate();
        for (int i = 0; i < N.length; i++) {
            assertThat(sut.solution(N[i], stages[i])).isEqualTo(result[i]);
        }
    }
}