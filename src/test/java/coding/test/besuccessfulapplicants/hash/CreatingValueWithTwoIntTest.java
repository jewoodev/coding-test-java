package coding.test.besuccessfulapplicants.hash;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreatingValueWithTwoIntTest {
    @Test
    void test() {
        int[][] arr = {
                {1,2,3,4,8},
                {2,3,5,9}
        };
        int[] target = {6, 10};
        boolean[] expected = {true, false};

        var sut = new CreatingValueWithTwoInt();
        for (int i = 0; i < arr.length; i++) {
            assertThat(sut.solution(arr[i], target[i])).isEqualTo(expected[i]);
        }
    }
}