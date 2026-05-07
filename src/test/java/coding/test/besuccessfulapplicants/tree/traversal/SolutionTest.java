package coding.test.besuccessfulapplicants.tree.traversal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SolutionTest {
    @Test
    void test() {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        String[] expected = {"1 2 4 5 3 6 7", "4 2 5 1 6 3 7", "4 5 2 6 7 3 1"};

        var sut = new Solution();
        var actual = sut.solution(input);
        for (int i = 0; i < expected.length; i++) {
            assertThat(expected[i]).isEqualTo(actual[i]);
        }
    }
}